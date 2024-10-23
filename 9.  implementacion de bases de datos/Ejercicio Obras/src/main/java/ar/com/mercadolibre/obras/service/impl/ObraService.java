package ar.com.mercadolibre.obras.service.impl;

import ar.com.mercadolibre.obras.model.Obra;
import ar.com.mercadolibre.obras.repository.ObraRepository;
import ar.com.mercadolibre.obras.service.IObraService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObraService implements IObraService {

    private final ObraRepository repository;

    public Obra save(Obra obra){
        return repository.save(obra);
    }

    public List<Obra> getAllObras(){
        Page<Obra> page = repository.findAll(PageRequest.of(0, 10));
        return page.getContent();
    }

    public List<Obra> getObrasByName(String name){
        Page<Obra> page = repository.findByNombreContaining(name, PageRequest.of(0, 10));
        return page.getContent();
    }

    public List<Obra> getObrasByNameFuzzy(String name){
        Page<Obra> page = repository.findByNombreSimilar(name, PageRequest.of(0, 10));
        return page.getContent();
    }

    @Override
    public List<Obra> getObraByAutor(String autor) {
        Page<Obra> page = repository.findByAutorMatches(autor, PageRequest.of(0, 10));
        return page.getContent();
    }

    @Override
    public List<Obra> getTopByPaginas(){
        Page<Obra> page = repository.findTop5ByOrderByPaginasDesc( PageRequest.of(0, 5));
        return page.getContent();
    }

    @Override
    public List<Obra> getObrasByAnio(Integer year){
        Page<Obra> page = repository.findByAnioPublicacionBefore(year, PageRequest.of(0, 5));
        return page.getContent();
    }

    @Override
    public List<Obra> getByEditorial(String editorial){
        Page<Obra> page = repository.findByEditorial(editorial, PageRequest.of(0, 5));
        return page.getContent();
    }
}
