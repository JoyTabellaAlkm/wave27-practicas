package ar.com.mercadolibre.ejercicioDeportistas.repository;

import ar.com.mercadolibre.ejercicioDeportistas.entitys.Deporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class DeporteRepository {
      Deporte deporte1 = new Deporte("Handball", "Medio");

      Deporte deporte2 = new Deporte("Voleyball", "Dificil");

      Deporte deporte3 = new Deporte("Futbol", "Facil");

      Deporte deporte4 = new Deporte("Basketball", "Facil");

      List<Deporte> deportes = new ArrayList<>(Arrays.asList(deporte1,
            deporte2, deporte3, deporte4));

      public List<Deporte> getAllDeportes(){
            return deportes;
      }
}
