package ar.com.mercadolibre.empleados.repository;

import ar.com.mercadolibre.empleados.entity.Empleado;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends ElasticsearchRepository<Empleado,Long> {
}