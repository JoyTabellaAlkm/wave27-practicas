package co.com.mercadolibre.calcularcalorias.service;

import co.com.mercadolibre.calcularcalorias.dto.request.PlatoDTORequest;
import co.com.mercadolibre.calcularcalorias.dto.response.PlatoDTOResponse;

import java.util.List;

public interface IPlatoService {
    PlatoDTOResponse verPlato(String nombre, Integer peso);
    List<PlatoDTOResponse> verPlatos (List<PlatoDTORequest> platosDTORequest);
}
