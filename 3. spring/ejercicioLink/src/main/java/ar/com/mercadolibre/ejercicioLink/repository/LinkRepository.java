package ar.com.mercadolibre.ejercicioLink.repository;

import ar.com.mercadolibre.ejercicioLink.entitys.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepository implements IRepository{

    private static HashMap<Integer, Link> links = new HashMap<>();

    Integer idActual = 0;

    public Integer addLink(Link link){

        idActual++;

        links.put(idActual, link);

        return idActual;
    }

    public Link getLinkById(Integer id){
        return links.get(id);
    }

    public boolean findById(){
        return false;
    }



}
