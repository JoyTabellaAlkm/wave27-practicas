package ar.com.mercadolibre.showroom.service.Impl;

import ar.com.mercadolibre.showroom.dto.CreateOkDTO;
import ar.com.mercadolibre.showroom.dto.PrendaDTO;
import ar.com.mercadolibre.showroom.entity.Prenda;
import ar.com.mercadolibre.showroom.repository.IPrendaRepository;
import ar.com.mercadolibre.showroom.service.IPrendaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrendaServiceImpl implements IPrendaService {

    @Autowired
    ModelMapper modelMapper;

    private final IPrendaRepository prendaRepository;

    @Autowired
    public PrendaServiceImpl(IPrendaRepository prendaRepository) {
        this.prendaRepository = prendaRepository;
    }

    @Override
    public CreateOkDTO createPrenda(PrendaDTO prenda){
        Prenda prenda1 = modelMapper.map(prenda, Prenda.class);
        prendaRepository.save(prenda1);
        return new CreateOkDTO("Prenda creada con éxito!");
    }

    @Override
    public List<PrendaDTO> getAllPrendas(){
        List<Prenda> prendas= prendaRepository.findAll();
        return prendas.stream()
                .map(prenda -> modelMapper.map(prenda, PrendaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PrendaDTO getPrenda(Long codigo){
        Optional<Prenda> prenda = prendaRepository.findById(codigo);
        return modelMapper.map(prenda, PrendaDTO.class);
    }

    @Override
    public CreateOkDTO updatePrenda(Long codigo, PrendaDTO prendaDTO){
        Optional<Prenda> prenda = prendaRepository.findById(codigo);
        if (prenda.isPresent()) {
            Prenda prenda1 = prenda.get();
            prenda1.setNombre(prendaDTO.getNombre());
            prenda1.setTipo(prendaDTO.getTipo());
            prenda1.setMarca(prendaDTO.getMarca());
            prenda1.setColor(prendaDTO.getColor());
            prenda1.setTalle(prendaDTO.getTalle());
            prenda1.setCantidad(prendaDTO.getCantidad());
            prenda1.setPrecioVenta(prendaDTO.getPrecioVenta());
            prendaRepository.save(prenda1);
        }
        return new CreateOkDTO("Prenda actualizada con éxito!");
    }

    @Override
    public CreateOkDTO deletePrenda(Long codigo){
        Optional<Prenda> prenda = prendaRepository.findById(codigo);
        prenda.ifPresent(prendaRepository::delete);
        return new CreateOkDTO("Prenda eliminada con éxito!");
    }

    @Override
    public List<PrendaDTO> getAllPrendasBySize(String size){
        List<Prenda> prendas = prendaRepository.findAllByTalle(size);
        return prendas.stream()
                .map(prenda -> modelMapper.map(prenda, PrendaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PrendaDTO> getAllPrendasByName(String name){
        List<Prenda> prendas = prendaRepository.findAllByNombreContainsIgnoreCase(name);
        return prendas.stream()
                .map(prenda -> modelMapper.map(prenda, PrendaDTO.class))
                .collect(Collectors.toList());
    }
}
