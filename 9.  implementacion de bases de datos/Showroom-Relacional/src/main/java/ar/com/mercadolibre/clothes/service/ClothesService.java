package ar.com.mercadolibre.clothes.service;

import ar.com.mercadolibre.clothes.entity.Clothes;
import ar.com.mercadolibre.clothes.repository.IClothesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesService implements IClothesService{
    private final IClothesRepository clothesRepository;

    public ClothesService(IClothesRepository clothesRepository){this.clothesRepository = clothesRepository;}

    @Override
    public Clothes save(Clothes clothes) {
        return clothesRepository.save(clothes);
    }

    @Override
    public List<Clothes> findAll() {
        return clothesRepository.findAll();
    }

    @Override
    public Clothes findClothes(Long code) {
        return clothesRepository.findById(code).orElseThrow(()->new RuntimeException("No encontrado"));
    }

    @Override
    public Clothes updateClothes(Long code, Clothes clothes) {
        Clothes modified = findClothes(code);

        modified.setName(clothes.getName());
        modified.setType(clothes.getType());
        modified.setBrand(clothes.getBrand());
        modified.setColor(clothes.getColor());
        modified.setSize(clothes.getSize());
        modified.setQuantity(clothes.getQuantity());
        modified.setSelling_price(clothes.getSelling_price());

        save(modified);
        return modified;
    }

    @Override
    public String deleteClothes(Long code) {
        Clothes deleted = findClothes(code);
        clothesRepository.delete(deleted);
        return "Eliminado correctamente";
    }

    @Override
    public List<Clothes> findAllBySize(Double size) {
        return clothesRepository.findAllBySize(size);
    }

    @Override
    public List<Clothes> findAllByName(String name) {
        return clothesRepository.findAllByNameContainingIgnoreCase(name);
    }
}
