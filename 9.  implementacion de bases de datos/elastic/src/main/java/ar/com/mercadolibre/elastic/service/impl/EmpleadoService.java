package ar.com.mercadolibre.elastic.service.impl;

import ar.com.mercadolibre.elastic.model.Empleado;
import ar.com.mercadolibre.elastic.repository.EmpleadoRepository;
import ar.com.mercadolibre.elastic.service.IEmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoService implements IEmpleadoService {

    private final EmpleadoRepository repository;

    public Empleado save(Empleado empleado){
        return repository.save(empleado);
    }

    @Override
    public List<Empleado> getAll() {
        return repository.findAll();
    }

    @Override
    public Empleado getById(Integer id) {
        return repository.findById(id);
    }
}
