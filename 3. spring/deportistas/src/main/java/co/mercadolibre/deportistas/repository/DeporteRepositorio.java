package co.mercadolibre.deportistas.repository;

import co.mercadolibre.deportistas.entity.Deporte;
import co.mercadolibre.deportistas.entity.DeporteDeportista;
import co.mercadolibre.deportistas.entity.Deportista;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeporteRepositorio {
    List<Deporte> listaDeportes;
    List<Deportista> listaDeportista;
    List<DeporteDeportista> listaDeporteDeportista;

    public DeporteRepositorio() {
        listaDeportes = new ArrayList<>();
        listaDeportes.add(new Deporte("Natacion",1));
        listaDeportes.add(new Deporte("Tennis",1));
        listaDeportes.add(new Deporte("Fulbo",1));

        listaDeportista = new ArrayList<>();

        listaDeportista.add(new Deportista("Juan","Diaz",22));
        listaDeportista.add(new Deportista("Brayan","Perez",23));

        listaDeporteDeportista = new ArrayList<>();
        listaDeporteDeportista.add(new DeporteDeportista(
                listaDeportista.stream().filter(deportista -> deportista.getNombre().equals("Juan")).findFirst().orElse(null),
                listaDeportes
        ));
        listaDeporteDeportista.add(new DeporteDeportista(
                listaDeportista.stream().filter(deportista -> deportista.getNombre().equals("Juan")).findFirst().orElse(null),
                listaDeportes.stream().filter(deporte -> deporte.getNombre().equals("Fulbo")).toList()
        ));

    }

    public List<Deporte> getListaDeportes(){
        return listaDeportes;
    }

    public List<DeporteDeportista> getListaDeporteDeportista(){
        return listaDeporteDeportista;
    }


}
