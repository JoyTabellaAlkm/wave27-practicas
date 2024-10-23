package co.mercadolibre.seguros_autos.service.impl;

import co.mercadolibre.seguros_autos.dto.request.VehiculoRequestDTO;
import co.mercadolibre.seguros_autos.dto.response.PatenteDTO;
import co.mercadolibre.seguros_autos.dto.response.PatenteMarcaDTO;
import co.mercadolibre.seguros_autos.dto.response.PatenteMarcaModeloDTO;
import co.mercadolibre.seguros_autos.dto.response.VehiculoResponseDTO;
import co.mercadolibre.seguros_autos.entity.Vehiculo;
import co.mercadolibre.seguros_autos.repository.IVehiculoRepository;
import co.mercadolibre.seguros_autos.service.IVehiculoService;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    private final IVehiculoRepository iVehiculoRepository;

    public VehiculoServiceImpl(IVehiculoRepository iVehiculoRepository) {
        this.iVehiculoRepository = iVehiculoRepository;
    }

    ModelMapper modelMapper = new ModelMapper();
    @Override
    @Transactional
    public VehiculoResponseDTO crearVehiculo(VehiculoRequestDTO vehiculoRequestDTO) {
        Vehiculo vehiculo = modelMapper.map(vehiculoRequestDTO,Vehiculo.class);
        vehiculo = iVehiculoRepository.save(vehiculo);
        return modelMapper.map(vehiculo, VehiculoResponseDTO.class);
    }


    @Override
    @Transactional(readOnly = true)
    public List<VehiculoResponseDTO> findAllVehiculo() {
        return iVehiculoRepository.findAll()
                               .stream().map(v -> modelMapper.map(v, VehiculoResponseDTO.class))
                               .toList();
    }

    @Override
    public PatenteDTO findAllPatente(){
        return new PatenteDTO(iVehiculoRepository.getPatentes());
    }

    @Override
    public List<PatenteMarcaDTO> findAllPatentesAndMarcaOrderByAnioFabricacion(){

        return iVehiculoRepository.getAllPatentesAndMarcaOrderByAnioFabricacion().stream()
                .map(v -> new PatenteMarcaDTO((String) v[0], (String) v[1]))
                .toList();

    }

    @Override
    public PatenteDTO findPatentesByCantidadRuedasAndAnioFabricacionCurrentYear(){
        return new PatenteDTO(iVehiculoRepository.getPatentesByCantidadRuedasAndAnioFabricacionCurrentYear());
    }

    @Override
    public List<PatenteMarcaModeloDTO> findVehiculosByPerdidaEconomicaAbove10000(){

        return iVehiculoRepository.getVehiculosByPerdidaEconomicaAbove10000().stream()
                .map(v -> new PatenteMarcaModeloDTO((String) v[0], (String) v[1], (String) v[2]))
                .toList();
    }

}
