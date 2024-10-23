package com.mercadolibre.joyeria.services.impl;

import com.mercadolibre.joyeria.dtos.JoyaDTO;
import com.mercadolibre.joyeria.dtos.requests.RequestJoyaDTO;
import com.mercadolibre.joyeria.dtos.requests.RequestUpdateJoyaDTO;
import com.mercadolibre.joyeria.dtos.responses.ResponseJoyaDTO;
import com.mercadolibre.joyeria.dtos.responses.ResponseUpdateJoyaDTO;
import com.mercadolibre.joyeria.entities.Joya;
import com.mercadolibre.joyeria.exceptions.NotFoundException;
import com.mercadolibre.joyeria.repositories.JoyaRepository;
import com.mercadolibre.joyeria.services.IJoyaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaServiceImpl implements IJoyaService {

    @Autowired
    JoyaRepository joyaRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public ResponseJoyaDTO crearJoya(RequestJoyaDTO requestJoyaDTO) {
        Joya joya = modelMapper.map(requestJoyaDTO,Joya.class);
        joyaRepository.save(joya);
        return new ResponseJoyaDTO(joya.getId(),"Joya creada exitosamente");
    }

    @Override
    public List<JoyaDTO> mostrarJoyas() {
        return joyaRepository.findAll().stream().filter(Joya::isVentaONo).map(j-> modelMapper.map(j,JoyaDTO.class)).toList();
    }

    @Override
    public ResponseJoyaDTO eliminarJoyaResgistrada(Integer id) {
        Joya joyaToUpdate = joyaRepository.findById(id).orElseThrow(()->new NotFoundException("No se econcotró la joya a eliminar"));
        joyaToUpdate.setVentaONo(false);
        joyaRepository.save(joyaToUpdate);
        return new ResponseJoyaDTO(id,"Joya eliminada exitosamente");
    }

    @Override
    public List<JoyaDTO> mostrarTodo() {
        return joyaRepository.findAll().stream().map(j-> modelMapper.map(j,JoyaDTO.class)).toList();
    }

    @Override
    public ResponseUpdateJoyaDTO actualizarParticularidadJoya(Integer idModificar, RequestUpdateJoyaDTO requestJoyaDTO) {
        Joya joyaToUpdate = joyaRepository.findById(idModificar).orElseThrow(()->new NotFoundException("No se econcotró la joya a actualizar"));
        joyaToUpdate.setParticularidad(requestJoyaDTO.getParticularidad());
        joyaRepository.save(joyaToUpdate);
        return new ResponseUpdateJoyaDTO(idModificar,joyaToUpdate.getNombre(),joyaToUpdate.getMaterial(),joyaToUpdate.getPeso(),joyaToUpdate.getParticularidad(), joyaToUpdate.isPoseePiedra(), joyaToUpdate.isVentaONo(), "Se actualizó la joya correctamente");
    }
}
