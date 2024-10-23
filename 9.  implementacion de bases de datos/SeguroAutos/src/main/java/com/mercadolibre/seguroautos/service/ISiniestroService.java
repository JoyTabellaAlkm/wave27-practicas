package com.mercadolibre.seguroautos.service;

import com.mercadolibre.seguroautos.dto.SiniestroDTO;
import com.mercadolibre.seguroautos.entity.Siniestro;

public interface ISiniestroService {
    String agregarSiniestro(SiniestroDTO siniestroDTO);
}
