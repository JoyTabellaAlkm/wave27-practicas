package ar.com.mercadolibre.elastic.service.impl;


import ar.com.mercadolibre.elastic.model.Articulo;
import ar.com.mercadolibre.elastic.repository.ArticuloRepository;
import ar.com.mercadolibre.elastic.service.IArticuloService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticuloService implements IArticuloService {

    private final ArticuloRepository repository;
    //private final ElasticsearchOperations repository;

    public Articulo save(Articulo articulo) {
        return repository.save(articulo);
    }

    public Optional<Articulo> findById(int id) {
        return repository.findById(id);
    }

    public Iterable<Articulo> findAll() {
        return repository.findAll();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
