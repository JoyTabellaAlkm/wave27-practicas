package com.mercadolibre.empleados.repository;

import com.mercadolibre.empleados.enitity.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado, String> {


}
