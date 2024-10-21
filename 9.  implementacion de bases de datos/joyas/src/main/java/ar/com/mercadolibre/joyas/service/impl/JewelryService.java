package ar.com.mercadolibre.joyas.service.impl;

import ar.com.mercadolibre.joyas.model.Jewelry;
import ar.com.mercadolibre.joyas.model.dto.request.CreateJewelryDTO;
import ar.com.mercadolibre.joyas.model.dto.request.UpdateJewelryDTO;
import ar.com.mercadolibre.joyas.repository.JewelryRepository;
import ar.com.mercadolibre.joyas.service.IJewelryService;
import ar.com.mercadolibre.joyas.util.Utils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JewelryService implements IJewelryService {

    private final JewelryRepository repository;

    public JewelryService(JewelryRepository repository){
        this.repository = repository;
    }


    @Override
    public Long createJewelry(CreateJewelryDTO jewelryDTO) {
        Jewelry toSave = Utils.changeDtoToEntity(jewelryDTO, Jewelry.class);

        Jewelry saved = repository.save(toSave);
        return saved.getId();
    }

    @Override
    public List<Jewelry> getAllJewelry() {
        return repository.findAll().stream()
                .filter(Jewelry::getSellOrNot)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteJewelry(Long id) {
        Jewelry toDelete = repository.findById(id).orElseThrow(() -> new RuntimeException("Jewelry not found"));
        toDelete.setSellOrNot(false);
        repository.save(toDelete);
    }

    @Override
    public Jewelry updateJewelry(Long id, UpdateJewelryDTO jewelryDTO) {
        Jewelry toUpdate = repository.findById(id).orElseThrow(() -> new RuntimeException("Jewelry not found"));

        toUpdate.setName(jewelryDTO.getName());
        toUpdate.setMaterial(jewelryDTO.getMaterial());
        toUpdate.setWeight(jewelryDTO.getWeight());
        toUpdate.setParticularity(jewelryDTO.getParticularity());
        toUpdate.setHasStone(jewelryDTO.getHasStone());

        return repository.save(toUpdate);
    }
}
