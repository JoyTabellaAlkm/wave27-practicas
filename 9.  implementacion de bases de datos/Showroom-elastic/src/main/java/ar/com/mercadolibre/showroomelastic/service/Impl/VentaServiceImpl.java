package ar.com.mercadolibre.showroomelastic.service.Impl;

import ar.com.mercadolibre.showroomelastic.dto.CreateOkDTO;
import ar.com.mercadolibre.showroomelastic.dto.PrendaDTO;
import ar.com.mercadolibre.showroomelastic.dto.VentaDTO;
import ar.com.mercadolibre.showroomelastic.entity.Prenda;
import ar.com.mercadolibre.showroomelastic.entity.Venta;
import ar.com.mercadolibre.showroomelastic.repository.IVentaRepository;
import ar.com.mercadolibre.showroomelastic.service.IVentaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VentaServiceImpl implements IVentaService {
    @Autowired
    ModelMapper modelMapper;

    private final IVentaRepository ventaRepository;

    @Autowired
    public VentaServiceImpl(IVentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public CreateOkDTO createVenta(VentaDTO ventaDTO){
        Venta venta = modelMapper.map(ventaDTO, Venta.class);
        ventaRepository.save(venta);
        return new CreateOkDTO("Venta creada con éxito!");
    }

    @Override
    public List<VentaDTO> getAllVentas(){
        List<Venta> ventas = (List<Venta>) ventaRepository.findAll();
        return ventas.stream()
                .map(prenda -> modelMapper.map(prenda, VentaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public VentaDTO getVenta(Long codigo){
        Optional<Venta> venta = ventaRepository.findById(codigo);
        return modelMapper.map(venta, VentaDTO.class);
    }

    @Override
    public CreateOkDTO updateVenta(Long codigo, VentaDTO ventaDTO){
        Optional<Venta> venta = ventaRepository.findById(codigo);
        if (venta.isPresent()) {
            Venta venta1 = venta.get();
            venta1.setFecha(ventaDTO.getFecha());
            venta1.setTotal(ventaDTO.getTotal());
            venta1.setMedioPago(ventaDTO.getMedioPago());
            venta1.setPrendas(ventaDTO.getPrendas());
            ventaRepository.save(venta1);
        }
        return new CreateOkDTO("Venta actualizada con éxito!");
    }

    @Override
    public CreateOkDTO deleteVenta(Long codigo){
        Optional<Venta> venta = ventaRepository.findById(codigo);
        venta.ifPresent(ventaRepository::delete);
        return new CreateOkDTO("Venta eliminada con éxito!");
    }

    @Override
    public List<VentaDTO> getAllVentasByDate(LocalDate date){
        List<Venta> ventas = ventaRepository.findAllByFecha(date);
        return ventas.stream()
                .map(venta -> modelMapper.map(venta, VentaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PrendaDTO> getAllVentasByPrendas(Long number){
        Optional<Venta> ventas = ventaRepository.findById(number);
        List<Prenda> prendas = ventas.get().getPrendas();
        return prendas.stream()
                .map(prenda -> modelMapper.map(prenda, PrendaDTO.class))
                .collect(Collectors.toList());
    }

}
