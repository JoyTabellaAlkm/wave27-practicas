package ar.com.autosusados.autosusados.repositories.impl;

import ar.com.autosusados.autosusados.entities.AutoUsados;
import ar.com.autosusados.autosusados.repositories.IAutoUsadosRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class AutosUsadosRepository implements IAutoUsadosRepository {
    private List<AutoUsados> autoUsados;

    public AutosUsadosRepository() {
        this.autoUsados = new ArrayList<AutoUsados>();
    }

    @Override
    public AutoUsados getAutoDTOId(Long id) {
        return autoUsados.stream().filter( auto -> auto.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<AutoUsados> getAutoDTOBetweenPrices(Double since, Double to) {
        List<AutoUsados> autos = new ArrayList<>();
        for (AutoUsados auto : autoUsados) {
            if(auto.getPrice() >= since && auto.getPrice() <= to) {
                autos.add(auto);
            }
        }
        return autos;
    }

    @Override
    public List<AutoUsados> getAutosBetweenDates(Date since, Date to) {
        List<AutoUsados> autos = new ArrayList<>();
        for (AutoUsados auto : autoUsados) {
            if(auto.getManufacturingDate().before(to) && auto.getManufacturingDate().after(since)) {
                autos.add(auto);
            }
        }
        return autos;
    }

    @Override
    public List<AutoUsados> getAutos() {
        return autoUsados;
    }

    @Override
    public boolean agregarAuto(AutoUsados auto) {
        return autoUsados.add(auto);
    }
}
