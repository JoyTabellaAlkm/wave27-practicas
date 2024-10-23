package ar.com.mercadolibre.elastic.repository;

import ar.com.mercadolibre.elastic.model.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, Integer> {
    Empleado save(Empleado empleado);

    List<Empleado> findAll();

    Empleado findById(Integer id);
}
