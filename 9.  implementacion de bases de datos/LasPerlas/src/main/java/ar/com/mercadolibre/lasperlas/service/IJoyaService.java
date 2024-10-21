package ar.com.mercadolibre.lasperlas.service;

import ar.com.mercadolibre.lasperlas.entity.Joya;

import java.util.List;

public interface IJoyaService {

    public List<Joya> getJoyas();
    public Long saveJoya(Joya joya);
    public Joya findJoya(Long id);

}
