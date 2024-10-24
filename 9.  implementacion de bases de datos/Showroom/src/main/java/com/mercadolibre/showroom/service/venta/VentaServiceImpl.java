package com.mercadolibre.showroom.service.venta;

import com.mercadolibre.showroom.dto.PrendaResponseDTO;
import com.mercadolibre.showroom.dto.ResponseDTO;
import com.mercadolibre.showroom.dto.VentaRequestDTO;
import com.mercadolibre.showroom.dto.VentaResponseDTO;
import com.mercadolibre.showroom.entity.Prenda;
import com.mercadolibre.showroom.entity.Venta;
import com.mercadolibre.showroom.exception.NotFoundException;
import com.mercadolibre.showroom.repository.IPrendaRepository;
import com.mercadolibre.showroom.repository.IVentaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements IVentaService {

    @Autowired
    IVentaRepository ventaRepository;

    @Autowired
    IPrendaRepository prendaRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public VentaResponseDTO agregarVenta(VentaRequestDTO ventaRequestDTO) {
        Venta venta = modelMapper.map(ventaRequestDTO, Venta.class);

        double total;

        List<Prenda> prendas = new ArrayList<>();

        ventaRequestDTO.getListaPrendas()
                .forEach(prendaId -> prendas.add(prendaRepository.findById(prendaId)
                        .orElseThrow(() -> new RuntimeException("No existen prendas con ese ID"))));

        total = prendas.stream().mapToDouble(Prenda::getPrecioVenta).sum();

        venta.setTotal(total);
        venta.setListaPrendas(prendas);

        venta.setFecha(LocalDate.now());

        ventaRepository.save(venta);

        VentaResponseDTO ventaResponseDTO = modelMapper.map(venta, VentaResponseDTO.class);
        //No sé si esté mapeando bien las prendas
        return ventaResponseDTO;
    }

    @Override
    public ResponseDTO eliminarVenta(Long id) {
        Venta venta = ventaRepository.findById(id).orElseThrow(() -> new NotFoundException("No se encontró la venta a eliminar"));
        ventaRepository.delete(venta);
        return new ResponseDTO(200, "Prenda eliminada exitosamente");
    }

    @Override
    public List<VentaResponseDTO>obtenerVentas(){
      return ventaRepository.findAll()
              .stream().map(v -> modelMapper.map(v, VentaResponseDTO.class)).toList();
    }

    @Override
    public VentaResponseDTO getVentaByID (Long id){
        Venta venta = ventaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontro el id para esa venta"));
        return  modelMapper.map(venta,VentaResponseDTO.class);
    }

    @Override
    public ResponseDTO actualizarVenta(Long number, VentaRequestDTO ventaRequestDTO) {
        Venta venta = ventaRepository.findById(number).orElseThrow(() -> new NotFoundException("No se encontró la venta"));
        venta.setMedioPago(ventaRequestDTO.getMedioPago());
        boolean todasExisten = prendaRepository.findByIdIn(ventaRequestDTO.getListaPrendas()).size()==ventaRequestDTO.getListaPrendas().size();
        if (!todasExisten) {
            throw new NotFoundException("No se encontro alguna de las prendas");
        }
        venta.setListaPrendas(prendaRepository.findByIdIn(ventaRequestDTO.getListaPrendas()));
        ventaRepository.save(venta);
        return new ResponseDTO(HttpStatus.OK.value(), "Se actualizó la venta correctamente");
    }

    @Override
    public List<PrendaResponseDTO> devolverPrendasPorFecha(String date){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
        List<Venta> ventas = ventaRepository.findAllByFecha(localDate);
        return  ventas.stream().map(venta-> modelMapper.map(venta.getListaPrendas(),PrendaResponseDTO.class)).toList();
    }

    @Override
    public List<PrendaResponseDTO> getPrendasByVenta(Long number) {
        Optional<Venta> ventaOptional = ventaRepository.findById(number);
        if (ventaOptional.isPresent()) {
            Venta venta = ventaOptional.get();
            return venta.getListaPrendas().stream()
                    .map(prenda -> modelMapper.map(prenda, PrendaResponseDTO.class))
                    .toList();

        }
        return List.of();
    }
}
