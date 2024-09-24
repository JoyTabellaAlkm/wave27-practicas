package ar.com.mercadolibre.ejercicioLink.service;

import ar.com.mercadolibre.ejercicioLink.dto.CreateLinkDTO;
import ar.com.mercadolibre.ejercicioLink.dto.EstadisticaDTO;
import ar.com.mercadolibre.ejercicioLink.dto.LinkId;
import ar.com.mercadolibre.ejercicioLink.entitys.Link;
import ar.com.mercadolibre.ejercicioLink.exception.NotFoundExceptionURL;
import ar.com.mercadolibre.ejercicioLink.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements IService{
    @Autowired
    IRepository iRepository;

    public EstadisticaDTO obtenerEstadistica(Integer id){
        EstadisticaDTO estadisticaDTO;
        Link link = iRepository.getLinkById(id);
        estadisticaDTO = new EstadisticaDTO(link.getUrl(),link.getVecesAccedido());
        return estadisticaDTO;
    }

    public LinkId crearLink(CreateLinkDTO createLinkDTO){
        Link link = new Link(createLinkDTO.getUrl(), createLinkDTO.getPassword());

        Integer id = iRepository.addLink(link);

        LinkId linkId = new LinkId(id);

        return linkId;
    }

    public String getUrl(Integer id) {
        Link link = iRepository.getLinkById(id);

        if(link.getValido()){
            link.setVecesAccedido(link.getVecesAccedido() + 1);
        }else{
            throw new NotFoundExceptionURL("El link no es valido");
        }

        return link.getUrl();
    }

    public String invalidLink(Integer id) {
        Link link = iRepository.getLinkById(id);
        link.setValido(false);

        return "El link ya no es valido";
    }


}
