package ar.com.mercadolibre.joyeria.service;

import ar.com.mercadolibre.joyeria.dto.JoyaDto;

import java.util.List;

public interface IJoyeriaService {
    public List<JoyaDto> getJewel ();
    public String saveJewel (JoyaDto jewelDto);
    public String deleteJewel (long id);
    public JoyaDto findJewel (long id);
    public String editJewel(Long id, JoyaDto jewelDto);
}
