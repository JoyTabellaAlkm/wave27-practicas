package ar.com.mercadolibre.lasperlas.service;

import ar.com.mercadolibre.lasperlas.entity.Joya;
import ar.com.mercadolibre.lasperlas.repository.IJoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JoyaServiceImpl implements IJoyaService{

    @Autowired
    private final IJoyaRepository joyaRepository;

    private JoyaServiceImpl(IJoyaRepository joyaRepository){
        this.joyaRepository = joyaRepository;
    }

    @Override
    public List<Joya> getJoyas(){
        List<Joya> joyas = joyaRepository.findAll();
        return joyas.stream().filter(Joya::getVentaONo).toList();
    }

    @Override
    public Joya findJoya(Long id){
        return joyaRepository.findById(id).orElse(null);
    }

    @Override
    public Long saveJoya(Joya joya){
        joyaRepository.save(joya);
        return joya.getId();
    }


}
