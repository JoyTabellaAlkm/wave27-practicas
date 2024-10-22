package ar.com.mercadolibre.empresaseguros.service;

import ar.com.mercadolibre.empresaseguros.dto.*;
import ar.com.mercadolibre.empresaseguros.entity.Siniestro;
import ar.com.mercadolibre.empresaseguros.entity.Vehiculo;
import ar.com.mercadolibre.empresaseguros.repository.ISiniestroRepository;
import ar.com.mercadolibre.empresaseguros.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private final IVehiculoRepository vehiculoRepository;

    @Autowired
    private final ISiniestroRepository siniestroRepository;

    public VehiculoServiceImpl(IVehiculoRepository vehiculoRepository, ISiniestroRepository siniestroRepository) {
        this.vehiculoRepository = vehiculoRepository;
        this.siniestroRepository = siniestroRepository;
    }

    @Override
    public List<Vehiculo> getAllVehiculos(){
        return vehiculoRepository.findAll();
    }

    @Override
    public CreateOkDTO createVehiculo(Vehiculo vehiculo){
        vehiculoRepository.save(vehiculo);
        return new CreateOkDTO("Vehículo creado con éxito");
    }

    @Override
    public CreateOkDTO createSiniestro(Siniestro siniestro){
        siniestroRepository.save(siniestro);
        return new CreateOkDTO("Siniestro creado con éxito");
    }

    @Override
    public List<PatenteDTO> getVehiculoByPatente(){
         List<String> patentes = vehiculoRepository.getVehiculoByPatente();
         return patentes.stream()
                 .map(PatenteDTO::new)
                 .collect(Collectors.toList());
    }

    @Override
    public List<PatenteAndMarcaOrderDTO> getVehiculoByPatenteAndMarcaOrderByAnioFabricacion(){
        List<Object[]> results = vehiculoRepository.getVehiculoByPatenteAndMarcaOrderByAnioFabricacion();

        return results.stream()
                .map(result -> new PatenteAndMarcaOrderDTO((String) result[0], (String) result[1]))
                .collect(Collectors.toList());
    }

    @Override
    public List<PatenteDTO> getVehiculoByPatenteAndCantidadRuedasAfterFour(){
        List<String> patentes = vehiculoRepository.getVehiculoByPatenteAndCantidadRuedasAfterFour();
        System.out.println(patentes);
        return patentes.stream()
                .map(patente -> modelMapper.map(patente, PatenteDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculoDTO> getVehiculoBySiniestros() {
        List<Object[]> vehiculos = vehiculoRepository.getVehiculoBySiniestros();

        return vehiculos.stream()
                .map(result -> new VehiculoDTO(
                        (String) result[0],
                        (String) result[1],
                        (String) result[2]
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculoSiniestroDTO> getVehiculoBySiniestrosAndPerdida() {
        List<Object[]> vehiculos = vehiculoRepository.getVehiculoBySiniestrosAndPerdida();

        return vehiculos.stream()
                .map(result -> new VehiculoSiniestroDTO(
                        (String) result[0],
                        (String) result[1],
                        (String) result[2],
                        (Double) result[3]
                ))
                .collect(Collectors.toList());
    }

}
