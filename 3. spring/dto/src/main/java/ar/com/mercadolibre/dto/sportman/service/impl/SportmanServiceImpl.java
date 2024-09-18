package ar.com.mercadolibre.dto.sportman.service.impl;


import ar.com.mercadolibre.dto.sportman.model.Sport;
import ar.com.mercadolibre.dto.sportman.model.SportmanDTO;
import ar.com.mercadolibre.dto.sportman.repository.SportmanRepository;
import ar.com.mercadolibre.dto.sportman.service.ISportmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportmanServiceImpl implements ISportmanService {

    SportmanRepository sportmanRepository = new SportmanRepository();

    public List<Sport> getSportList() {
        return sportmanRepository.getSportList();
    }

    @Override
    public Sport getSport(String name) {
        return sportmanRepository.getSport(name);
    }

    @Override
    public List<SportmanDTO> getSportmanList() {
        return sportmanRepository.getSportmanDTOS();
    }
}
