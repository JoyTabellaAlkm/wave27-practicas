package co.mercadolibre.deportistas.service.impl;

import co.mercadolibre.deportistas.dto.ConsultaDTO;
import co.mercadolibre.deportistas.entity.Deporte;
import co.mercadolibre.deportistas.entity.DeporteDeportista;
import co.mercadolibre.deportistas.repository.DeporteRepositorio;
import co.mercadolibre.deportistas.service.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeporteService implements IDeporteService {

    @Autowired
    DeporteRepositorio deporteRepositorio;

    @Override
    public List<Deporte> getDeporte() {
        return deporteRepositorio.getListaDeportes();
    }

    @Override
    public Deporte getListaDeportesByName(String name) {
        return deporteRepositorio.getListaDeportes().stream().filter(d->d.getNombre().equals(name)).findFirst().orElse(null);
    }

    @Override
    public List<ConsultaDTO> getListaDeportesDeportistas() {
        return deporteRepositorio.getListaDeporteDeportista().stream().map(
                deporteDeportista -> new ConsultaDTO(
                        deporteDeportista.getDeportista().getNombre(),
                        deporteDeportista.getDeportista().getApellido(),
                        deporteDeportista.getDeporte()
                        )
                ).toList();
    }


}
