package ar.com.autosusados.autosusados.services.impl;

import ar.com.autosusados.autosusados.dtos.AutoDTO;
import ar.com.autosusados.autosusados.entities.AutoUsados;
import ar.com.autosusados.autosusados.exceptions.CrearRegistroException;
import ar.com.autosusados.autosusados.exceptions.NoSeEncontroELAutoIdException;
import ar.com.autosusados.autosusados.repositories.IAutoUsadosRepository;
import ar.com.autosusados.autosusados.services.IAutoUsadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AutoUsadosService implements IAutoUsadosService {

    @Autowired
    private IAutoUsadosRepository repository;

    private AutoDTO cargarAutoDTO(AutoUsados auto) {
        return new AutoDTO(auto.getBrand(),auto.getModel(),auto.getManufacturingDate(),auto.getNumberOfKilometers(),auto.getDoors(),auto.getPrice(),auto.getCurrency(),auto.getCountOfOwners(),auto.getServices());
    }

    private AutoUsados cargarAuto(AutoDTO autoDTO) {
        return new AutoUsados(autoDTO.getBrand(),autoDTO.getModel(), autoDTO.getManufacturingDate(),autoDTO.getNumberOfKilometers(),autoDTO.getDoors(),autoDTO.getPrice(),autoDTO.getCurrency(),autoDTO.getCountOfOwners(),autoDTO.getServices());
    }

    @Override
    public AutoDTO getAutoDTOId(Long id) {
        AutoUsados autoBuscado = repository.getAutoDTOId(id);
        if(autoBuscado == null) {
            throw new NoSeEncontroELAutoIdException();
        }
        return cargarAutoDTO(autoBuscado);
    }

    @Override
    public List<AutoDTO> getAutoDTOBetweenPrices(Double since, Double to) {
        return List.of();
    }

    @Override
    public List<AutoDTO> getAutosBetweenDates(Date since, Date to) {
        return List.of();
    }

    @Override
    public List<AutoDTO> getAutos() {
        return List.of();
    }

    @Override
    public boolean agregarAuto(AutoDTO auto) {
        AutoUsados autoUsado = cargarAuto(auto);
        if (!repository.agregarAuto(autoUsado)){
            throw new CrearRegistroException();
        }
        return true;
    }
}
