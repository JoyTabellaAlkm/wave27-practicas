package com.mercadolibre.showroom.service.prenda;

import com.mercadolibre.showroom.dto.PrendaRequestDTO;
import com.mercadolibre.showroom.dto.PrendaResponseDTO;
import com.mercadolibre.showroom.dto.ResponseDTO;
import com.mercadolibre.showroom.entity.Prenda;
import com.mercadolibre.showroom.exception.NotFoundException;
import com.mercadolibre.showroom.repository.IPrendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaServiceImpl implements IPrendaService{

    @Autowired
    IPrendaRepository prendaRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<PrendaResponseDTO> obtenerPrendas(){
        return prendaRepository.findAll()
                .stream().map(prenda -> modelMapper.map(prenda, PrendaResponseDTO.class)).toList();
    }
    @Override
    public ResponseDTO eliminarPrenda(Long id) {
        Prenda prenda = prendaRepository.findById(id).orElseThrow(() -> new NotFoundException("No se encontró la prenda a eliminar"));
        prendaRepository.delete(prenda);
        return new ResponseDTO(200, "Prenda eliminada exitosamente");
    }

    public PrendaResponseDTO agregarPrenda(PrendaRequestDTO prendaRequestDTO){
        Prenda prenda = modelMapper.map(prendaRequestDTO, Prenda.class);
        prendaRepository.save(prenda);
        return modelMapper.map(prenda, PrendaResponseDTO.class);
    }

    @Override
    public ResponseDTO actualizarPrenda(Long id, PrendaRequestDTO prendaRequestDTO) {
        Prenda prenda = prendaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontro el código para esa prenda"));
        prenda.setNombre(prendaRequestDTO.getNombre());
        prenda.setTalle(prendaRequestDTO.getTalle());
        prenda.setPrecioVenta(prendaRequestDTO.getPrecioVenta());
        prenda.setPrecioVenta(prendaRequestDTO.getPrecioVenta());
        prenda.setCantidad(prendaRequestDTO.getCantidad());
        prendaRepository.save(prenda);
        return new ResponseDTO(200, "Prenda actualizada exitosamente");
    }

    @Override
    public List<PrendaResponseDTO> obtenerPrendasPorNombre(String nombre) {
        List<Prenda> prendas = prendaRepository.findByNombreContainingIgnoreCase(nombre);
        return prendas.stream().map(prenda -> modelMapper.map(prenda, PrendaResponseDTO.class)).toList();
    }

    @Override
    public PrendaResponseDTO getPrendaByID (Long id){
        Prenda prenda = prendaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontro el codigo para esa prenda"));
        return  modelMapper.map(prenda,PrendaResponseDTO.class);
    }

    @Override
    public List<PrendaResponseDTO> obtenerPrendasPorTalle(String talle) {
        List<Prenda> prendas = prendaRepository.findByTalle(talle);
        return prendas.stream().map(prenda -> modelMapper.map(prenda, PrendaResponseDTO.class)).toList();
    }

}
