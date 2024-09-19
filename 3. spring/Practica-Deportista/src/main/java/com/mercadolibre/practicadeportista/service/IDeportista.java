package com.mercadolibre.practicadeportista.service;
import com.mercadolibre.practicadeportista.model.Deporte;
import com.mercadolibre.practicadeportista.model.DeportistaDTO;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public interface IDeportista {
    List<Deporte> obtenerLista();

    Deporte getDeporte(String nombre);

    List<DeportistaDTO> getDeportistas();

}
