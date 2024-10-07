package ar.com.mercadolibre.link.service;

import ar.com.mercadolibre.link.model.Link;
import ar.com.mercadolibre.link.model.dto.request.LinkRequestDTO;
import ar.com.mercadolibre.link.model.dto.response.LinkResponseDTO;

public interface ILinkService {

    Integer saveLink(LinkRequestDTO link);

    LinkResponseDTO redirect(Integer id, String password);

    Integer metricsById(Integer id);

    void invalidateLink(Integer id);
}
