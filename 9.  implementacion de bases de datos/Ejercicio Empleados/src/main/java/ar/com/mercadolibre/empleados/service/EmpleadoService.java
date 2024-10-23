package ar.com.mercadolibre.empleados.service;

import ar.com.mercadolibre.empleados.entity.Empleado;
import ar.com.mercadolibre.empleados.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService implements IEmpleadoService{
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public Empleado save(Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    public Empleado modificarEmpleado(Long id, Empleado empleado) {
        Empleado empleadoModificado = empleadoRepository.findById(id).orElse(null);
        empleadoModificado.setNombre(empleado.getNombre());
        empleadoModificado.setApellido(empleado.getApellido());
        empleadoModificado.setEdad(empleado.getEdad());
        empleadoModificado.setCiudad(empleado.getCiudad());
        empleadoModificado.setProvincia(empleado.getProvincia());
        empleadoModificado.setEstado(empleado.getEstado());

        return empleadoRepository.save(empleadoModificado);
    }
}
