package co.com.mercadolibre.calcularcalorias.service.impl;

import co.com.mercadolibre.calcularcalorias.dto.request.PlatoDTORequest;
import co.com.mercadolibre.calcularcalorias.dto.response.PlatoDTOResponse;
import co.com.mercadolibre.calcularcalorias.entity.Plato;
import co.com.mercadolibre.calcularcalorias.exception.DishNotFoundException;
import co.com.mercadolibre.calcularcalorias.repository.IPlatoRepository;
import co.com.mercadolibre.calcularcalorias.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class PlatoServiceImpl implements IPlatoService {
    @Autowired
    IPlatoRepository platoRepository;

    @Override
    public PlatoDTOResponse verPlato(String nombre, Integer peso) {
    try{
        Optional<Plato> platoEncontrado = platoRepository.verPlatos().stream()
                .filter(plato -> plato.getNombre().equals(nombre) && plato.getPeso().equals(peso))
                .findFirst();
        PlatoDTOResponse platoDTOResponse = new PlatoDTOResponse(platoEncontrado.get().getIngredientes());
        return platoDTOResponse;

    }catch (Exception e){
        throw new DishNotFoundException("Plato no encontrado.");
    }

    }

    @Override
    public List<PlatoDTOResponse> verPlatos(List<PlatoDTORequest> platosDTORequest) {
        try{
            String nombre;
            Integer peso;
            List<PlatoDTOResponse> platoDTOResponses = new ArrayList<>();
            for(PlatoDTORequest plato : platosDTORequest){
                nombre = plato.getName();
                peso = plato.getPeso();
                PlatoDTOResponse platoDTOResponse = verPlato(nombre,peso);
                platoDTOResponses.add(platoDTOResponse);
            }
            return platoDTOResponses;
        }catch (Exception e){
            throw new DishNotFoundException("Platos no encontrados.");
        }

    }
}
