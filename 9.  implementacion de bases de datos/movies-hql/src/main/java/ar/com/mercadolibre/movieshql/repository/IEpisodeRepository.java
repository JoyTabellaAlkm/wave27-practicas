package ar.com.mercadolibre.movieshql.repository;

import ar.com.mercadolibre.movieshql.entity.Actor;
import ar.com.mercadolibre.movieshql.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IEpisodeRepository extends JpaRepository<Episode, Long> {
    //Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>
}
