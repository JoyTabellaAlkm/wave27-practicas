package com.mercadolibre.obrasliterariaselasticsearch.service;

import com.mercadolibre.obrasliterariaselasticsearch.dto.ObraLiterariaRequestDTO;
import com.mercadolibre.obrasliterariaselasticsearch.dto.ObraLiterariaResponseDTO;
import com.mercadolibre.obrasliterariaselasticsearch.entity.ObraLiteraria;
import com.mercadolibre.obrasliterariaselasticsearch.repository.IObrasLiterariasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObrasLiterariasServiceImpl implements IObrasLiterariasService{

    @Autowired
    private IObrasLiterariasRepository obrasLiterariasRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ObraLiterariaResponseDTO> getObrasLiterariasByAutor(String autor) {
        List<ObraLiteraria> obraLiterarias = obrasLiterariasRepository.findByAutorContainingIgnoreCase(autor);
        List<ObraLiterariaResponseDTO> obraLiterariaResponseDTOS = new ArrayList<>();
        obraLiterarias.forEach(obraLiteraria ->
            obraLiterariaResponseDTOS.add(modelMapper.map(obraLiteraria, ObraLiterariaResponseDTO.class))
        );
        return obraLiterariaResponseDTOS;
    }

    @Override
    public List<ObraLiterariaResponseDTO> getObrasLiterariasByTitle(String title) {
        List<ObraLiteraria> obraLiterarias = obrasLiterariasRepository.findByTituloContainingIgnoreCase(title);
        List<ObraLiterariaResponseDTO> obraLiterariaResponseDTOS = new ArrayList<>();
        obraLiterarias.forEach(obraLiteraria ->
            obraLiterariaResponseDTOS.add(modelMapper.map(obraLiteraria, ObraLiterariaResponseDTO.class))
        );
        return obraLiterariaResponseDTOS;
    }

    @Override
    public List<ObraLiterariaResponseDTO> getTop5ObrasLiterariasByPages() {
        List<ObraLiteraria> obraLiterarias = obrasLiterariasRepository.findTop5ByOrderByPaginasDesc();
        List<ObraLiterariaResponseDTO> obraLiterariaResponseDTOS = new ArrayList<>();
        obraLiterarias.forEach(obraLiteraria ->
            obraLiterariaResponseDTOS.add(modelMapper.map(obraLiteraria, ObraLiterariaResponseDTO.class))
        );
        return obraLiterariaResponseDTOS;
    }

    @Override
    public List<ObraLiterariaResponseDTO> getObrasLiterariasAfterYear(Integer year) {
        List<ObraLiteraria> obraLiterarias = obrasLiterariasRepository.findByAnioPublicacionBeforeOrderByAnioPublicacion(year);
        List<ObraLiterariaResponseDTO> obraLiterariaResponseDTOS = new ArrayList<>();
        obraLiterarias.forEach(obraLiteraria ->
            obraLiterariaResponseDTOS.add(modelMapper.map(obraLiteraria, ObraLiterariaResponseDTO.class))
        );
        return obraLiterariaResponseDTOS;
    }

    @Override
    public List<ObraLiterariaResponseDTO> getObrasLiterariasByEditorial(String editorial) {
        List<ObraLiteraria> obraLiterarias = obrasLiterariasRepository.findByEditorial(editorial);
        List<ObraLiterariaResponseDTO> obraLiterariaResponseDTOS = new ArrayList<>();
        obraLiterarias.forEach(obraLiteraria ->
            obraLiterariaResponseDTOS.add(modelMapper.map(obraLiteraria, ObraLiterariaResponseDTO.class))
        );
        return obraLiterariaResponseDTOS;
    }

    @Override
    public Boolean saveObraLiteraria(ObraLiterariaRequestDTO obraLiterariaRequestDTO) {
        ObraLiteraria obraLiteraria = modelMapper.map(obraLiterariaRequestDTO, ObraLiteraria.class);
        return obrasLiterariasRepository.save(obraLiteraria) != null;
    }
}
