package com.ejercicios.covid19.service.Impl;

import com.ejercicios.covid19.model.Sintoma;
import com.ejercicios.covid19.repository.ISintomaRepository;
import com.ejercicios.covid19.service.ISintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SintomaServiceImpl implements ISintomaService {
    @Autowired
    ISintomaRepository iSintomaRepository;

    @Override
    public List<Sintoma> verSintomas() {
       return iSintomaRepository.verSintomas();
    }

    @Override
    public String consultarSintoma(String nombre) {
      Optional<Sintoma> sintomaEcontrado =  verSintomas().stream().filter(sintoma -> sintoma.getNombre().equalsIgnoreCase(nombre)).findAny();
      if(sintomaEcontrado.isEmpty()){
          return null;
      }
      return sintomaEcontrado.get().getNivelDeGravedad();
    }
}
