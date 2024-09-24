package ar.com.mercadolibre.ejercicioLink.repository;


import ar.com.mercadolibre.ejercicioLink.entitys.Link;

public interface IRepository {

    Integer addLink(Link link);

    Link getLinkById(Integer id);



}
