package ar.com.mercadolibre.elastic.service;

import ar.com.mercadolibre.elastic.model.Empleado;

import java.util.List;

public interface IEmpleadoService {
    Empleado save(Empleado empleado);

    List<Empleado> getAll();

    Empleado getById(Integer id);
}
