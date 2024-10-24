package com.meli.showroom.service.impl;

import com.meli.showroom.dto.PrendaResponseDto;
import com.meli.showroom.dto.ResponseDto;
import com.meli.showroom.dto.VentaRequestDto;
import com.meli.showroom.dto.VentaResponseDto;
import com.meli.showroom.entity.Prenda;
import com.meli.showroom.entity.Venta;
import com.meli.showroom.exception.NotFoundException;
import com.meli.showroom.repository.IPrendaRepository;
import com.meli.showroom.repository.IVentaRepository;
import com.meli.showroom.service.IVentaService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class VentaServiceImpl implements IVentaService {
    private final IVentaRepository ventaRepository;
    private final IPrendaRepository prendaRepository;
    private ModelMapper mapper = new ModelMapper();

    public VentaServiceImpl(IVentaRepository ventaRepository, IPrendaRepository prendaRepository) {
        this.ventaRepository = ventaRepository;
        this.prendaRepository = prendaRepository;
    }

    @Override
    public VentaResponseDto nuevaVenta(VentaRequestDto venta) {
        Venta v = mapper.map(venta, Venta.class);
        List<Prenda> prendas = venta.getListaDePrendas().stream()
                .map(id -> prendaRepository.findById(id).orElseThrow(()->new NotFoundException("Prenda con id: %d".formatted(id))))
                .toList();
        v.setListaDePrendas(prendas);
        v.setNumero(null);
        ventaRepository.save(v);
        return mapper.map(v, VentaResponseDto.class);
    }

    @Override
    public List<VentaResponseDto> listarVentas(String date) {
        if (date == null){
            return ventaRepository.findAll().stream()
                    .map(venta -> mapper.map(venta, VentaResponseDto.class))
                    .toList();
        }

        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        return ventaRepository.findByFecha(localDate).stream()
                .map(venta -> mapper.map(venta, VentaResponseDto.class))
                .toList();
    }

    @Override
    public VentaResponseDto devolverVenta(Integer number) {
        Venta venta = this.findPrendaById(number);
        return mapper.map(venta, VentaResponseDto.class);
    }

    @Override
    public VentaResponseDto actualizarVenta(Integer number, VentaRequestDto ventaRequestDto) {
        this.findPrendaById(number);
        Venta venta = mapper.map(ventaRequestDto, Venta.class);
        List<Prenda> prendas = ventaRequestDto.getListaDePrendas().stream()
                .map(id -> prendaRepository.findById(id).orElseThrow(()->new NotFoundException("Prenda con id: %d".formatted(id))))
                .toList();
        venta.setListaDePrendas(prendas);
        venta.setNumero(number);
        venta = ventaRepository.save(venta);
        return mapper.map(venta, VentaResponseDto.class);
    }

    @Override
    public ResponseDto eliminarVenta(Integer number) {
        ventaRepository.findById(number).orElseThrow(()-> new NotFoundException("No existe la venta número: %d".formatted(number)));
        ventaRepository.deleteById(number);
        return new ResponseDto("Venta número %d eliminada correctamente".formatted(number), HttpStatus.OK);
    }

    @Override
    public List<PrendaResponseDto> listarPrendasVenta(Integer number) {
        Venta venta = this.findPrendaById(number);
        return venta.getListaDePrendas().stream()
                .map(prenda -> mapper.map(prenda, PrendaResponseDto.class))
                .toList();
    }

    private Venta findPrendaById(Integer number){
        return  ventaRepository.findById(number).orElseThrow(() -> new NotFoundException("No existe la venta número: %d".formatted(number)));
    }
}
