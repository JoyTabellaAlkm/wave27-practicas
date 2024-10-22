package ar.com.mercadolibre.movieshql.repository;

import ar.com.mercadolibre.movieshql.entity.Actor;
import ar.com.mercadolibre.movieshql.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IActorRepository extends JpaRepository<Actor, Long> {
    //Listar todos los actores que tengan declarada una película favorita.
    //Listar todos los actores que tengan rating superior a <valor recibido por parametro>
    //Listar todos los actores que trabajan en la <pelicula recibida por parametro>

}
