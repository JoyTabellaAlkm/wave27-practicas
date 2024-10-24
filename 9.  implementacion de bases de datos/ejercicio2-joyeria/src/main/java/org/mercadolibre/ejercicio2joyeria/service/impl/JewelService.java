package org.mercadolibre.ejercicio2joyeria.service.impl;

import org.mercadolibre.ejercicio2joyeria.dto.request.JewelDTO;
import org.mercadolibre.ejercicio2joyeria.dto.response.JewelResponseDTO;
import org.mercadolibre.ejercicio2joyeria.dto.response.JewelUpdateDTO;
import org.mercadolibre.ejercicio2joyeria.dto.response.ResponseDTO;
import org.mercadolibre.ejercicio2joyeria.entity.Jewel;
import org.mercadolibre.ejercicio2joyeria.exception.NotFoundException;
import org.mercadolibre.ejercicio2joyeria.repository.IJewelRepository;
import org.mercadolibre.ejercicio2joyeria.service.IJewelService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelService implements IJewelService {
    private final IJewelRepository iJewelRepository;

    public JewelService(IJewelRepository iJewelRepository) {
        this.iJewelRepository = iJewelRepository;
    }

    ModelMapper mapper = new ModelMapper();

    @Override
    public ResponseDTO createJewel(JewelDTO jewelDTO) {
        Jewel jewel = mapper.map(jewelDTO, Jewel.class);
        iJewelRepository.save(jewel);

        return new ResponseDTO(String.format("The jewel with the id: %d, has been successfully created", jewel.getId()), HttpStatus.CREATED);
    }

    @Override
    public List<JewelResponseDTO> getAllJewel() {

        List<JewelResponseDTO> jewelDTO = iJewelRepository.findAll()
                .stream().map(j -> mapper.map(j, JewelResponseDTO.class))
                .toList();

        return jewelDTO;
    }

    @Override
    public ResponseDTO deleteJewel(Long id) {
        Jewel jewel = this.findJewelById(id);
        jewel.setSaleOrNot(false);

        iJewelRepository.save(jewel);

        return new ResponseDTO(String.format("The jewel with id: %d, changed state successfully", id), HttpStatus.OK);
    }

    @Override
    public JewelUpdateDTO updateJewel(Long id, JewelDTO jewelDTO) {
        Jewel jewel = this.findJewelById(id);

        jewel.setName(jewelDTO.getName());
        jewel.setMaterial(jewelDTO.getMaterial());
        jewel.setWeight(jewelDTO.getWeight());
        jewel.setPeculiarity(jewelDTO.getPeculiarity());
        jewel.setHasStone(jewelDTO.getHasStone());
        jewel.setSaleOrNot(jewelDTO.getSaleOrNot());

        iJewelRepository.save(jewel);
        JewelDTO j = mapper.map(jewel, JewelDTO.class);

        return new JewelUpdateDTO(String.format("The jewel with the id: %d, was successfully updated", jewel.getId()), HttpStatus.OK, j);
    }

    private Jewel findJewelById(Long id){
        Jewel jewel = iJewelRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("The jewel with the id: %d was not found", id)));
        return jewel;
    }
}
