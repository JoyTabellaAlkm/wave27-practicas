package ar.com.mercadolibre.empleados.service;

import ar.com.mercadolibre.empleados.entity.Empleado;

import java.util.List;

public interface IEmpleadoService {
    Empleado save(Empleado empleado);
    Empleado modificarEmpleado(Long id, Empleado empleado);
}
