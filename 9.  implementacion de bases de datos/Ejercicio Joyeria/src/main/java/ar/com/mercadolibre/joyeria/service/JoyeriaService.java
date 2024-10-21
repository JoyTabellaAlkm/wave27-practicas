package ar.com.mercadolibre.joyeria.service;

import ar.com.mercadolibre.joyeria.dto.JoyaDto;
import ar.com.mercadolibre.joyeria.entity.Joya;
import ar.com.mercadolibre.joyeria.repository.JoyeriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyeriaService implements IJoyeriaService{

    private final JoyeriaRepository joyaRepo;
    private final ModelMapper modelMapper;

    public JoyeriaService(JoyeriaRepository joyaRepo, ModelMapper modelMapper) {
        this.joyaRepo = joyaRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<JoyaDto> getJewel() {
        return joyaRepo.findAll().stream()
                .filter(Joya::isVentaONo)
                .map(jewel->modelMapper.map(jewel, JoyaDto.class)).toList();
    }

    @Override
    public String saveJewel(JoyaDto jewelDto) {
        Joya jewel = modelMapper.map(jewelDto, Joya.class);
        joyaRepo.save(jewel);
        return "Creado correctamente con id " + jewel.getId();
    }

    @Override
    public String deleteJewel(long id) {
        joyaRepo.deleteById(id);
        return "Eliminado correctamente";
    }

    @Override
    public JoyaDto findJewel(long id) {
        Joya jewel = joyaRepo.findById(id).orElse(null);
        return modelMapper.map(jewel, JoyaDto.class);
    }

    @Override
    public String editJewel(Long id, JoyaDto jewelDto) {
        Joya joyaOriginal = joyaRepo.findById(id).
                orElseThrow(()-> new RuntimeException("Joya no encontrada"));

        joyaOriginal.setNombre(jewelDto.getNombre());
        joyaOriginal.setMaterial(jewelDto.getMaterial());
        joyaOriginal.setPeso(jewelDto.getPeso());
        joyaOriginal.setParticularidad(jewelDto.getParticularidad());
        joyaOriginal.setPoseePiedra(jewelDto.isPoseePiedra());
        joyaOriginal.setVentaONo(jewelDto.isVentaONo());

        JoyaDto originalJewel = modelMapper.map(joyaOriginal, JoyaDto.class);

        this.saveJewel(originalJewel);
        return "Modificado correctamente";
    }
}
