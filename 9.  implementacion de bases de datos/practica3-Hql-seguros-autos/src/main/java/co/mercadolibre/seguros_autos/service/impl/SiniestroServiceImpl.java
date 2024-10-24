package co.mercadolibre.seguros_autos.service.impl;

import co.mercadolibre.seguros_autos.dto.request.SiniestroRequestDTO;
import co.mercadolibre.seguros_autos.dto.response.PatenteMarcaModeloDTO;
import co.mercadolibre.seguros_autos.dto.response.PerdidasTotalesDTO;
import co.mercadolibre.seguros_autos.dto.response.SiniestroResponseDTO;
import co.mercadolibre.seguros_autos.entity.Siniestro;
import co.mercadolibre.seguros_autos.entity.Vehiculo;
import co.mercadolibre.seguros_autos.repository.ISiniestroRepository;
import co.mercadolibre.seguros_autos.repository.IVehiculoRepository;
import co.mercadolibre.seguros_autos.service.ISiniestroService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SiniestroServiceImpl implements ISiniestroService {


    private final ISiniestroRepository iSiniestroRepository;
    private final IVehiculoRepository iVehiculoRepository;
    public SiniestroServiceImpl(ISiniestroRepository iSiniestroRepository, IVehiculoRepository iVehiculoRepository) {
        this.iSiniestroRepository = iSiniestroRepository;
        this.iVehiculoRepository = iVehiculoRepository;
    }


    ModelMapper modelMapper = new ModelMapper();

    @Override
    @Transactional
    public SiniestroResponseDTO createSiniestro(SiniestroRequestDTO siniestroRequestDTO) {

        Siniestro siniestro = modelMapper.map(siniestroRequestDTO, Siniestro.class);

        Vehiculo vehiculo = iVehiculoRepository.findById(siniestroRequestDTO.getVehiculoId()).orElse(null);
        siniestro.setVehiculo(vehiculo);
        siniestro.setId(null);
        siniestro = iSiniestroRepository.save(siniestro);
        return modelMapper.map(siniestro, SiniestroResponseDTO.class);
    }


    @Override
    @Transactional(readOnly = true)
    public List<SiniestroResponseDTO> findAllSiniestro(){
        return iSiniestroRepository.findAll()
                .stream().map(v -> modelMapper.map(v, SiniestroResponseDTO.class))
                .toList();
    }

    @Override
    public List<PatenteMarcaModeloDTO> getVehiculosByPerdidaEconomicaAbove10000() {
        return iVehiculoRepository.getVehiculosByPerdidaEconomicaAbove10000()
                .stream().map(v -> new PatenteMarcaModeloDTO((String) v[0], (String) v[1], (String) v[2]))
                .toList();
    }

    @Override
    public List<PerdidasTotalesDTO> getVehiculosByPerdidaEconomicaAbove10000Agrupada() {
        return iVehiculoRepository.getVehiculosByPerdidaEconomicaAbove10000Agrupada()
                .stream().map(v -> new PerdidasTotalesDTO((String) v[0], (String) v[1], (String) v[2], (Double) v[3]))
                .toList();
    }
}
