package ar.com.mercadolibre.link.repository;

import ar.com.mercadolibre.link.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class LinkRepository {

    private List<Link> links = new ArrayList<>();

    public LinkRepository(){
        loadLinks();
    }

    private void loadLinks(){
        this.links.add(new Link(1, "http://www.mercadolibre.com.ar", 2, true, null));
        this.links.add(new Link(2, "http://www.youtube.com", 4, true, null));
        this.links.add(new Link(3, "http://www.gmail.com", 5, true, null));
        this.links.add(new Link(4, "http://www.yahoo.com", 1, true, null));
    }

    public Integer getNextId(){

        int nextId = this.links.stream()
                .mapToInt(Link::getId)
                .max()
                .orElse(0);

        return nextId + 1;
    }

    public Boolean saveLink(Link link){
        return this.links.add(link);
    }


    public Link getLinkById(Integer id){
        return this.links.stream()
                .filter(link -> link.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


    public Boolean existId(Integer id){
        return this.links.stream()
                .anyMatch(link -> link.getId().equals(id));
    }

    public void incrementMetrics(Link link){
        link.setMetrics(link.getMetrics() + 1);
    }

    public void invalidateLink(Link link){
        link.setValid(false);
    }


}
