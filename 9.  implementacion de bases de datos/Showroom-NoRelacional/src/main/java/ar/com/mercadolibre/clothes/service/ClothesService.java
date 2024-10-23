package ar.com.mercadolibre.clothes.service;

import ar.com.mercadolibre.clothes.entity.Clothes;
import ar.com.mercadolibre.clothes.repository.IClothesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

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
        Iterable<Clothes> clothes = clothesRepository.findAll();
        return StreamSupport.stream(clothes.spliterator(), false).toList();
    }

    @Override
    public Clothes findClothes(String code) {
        return clothesRepository.findById(code).orElseThrow(()->new RuntimeException("No encontrado"));
    }

    @Override
    public Clothes updateClothes(String code, Clothes clothes) {
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
    public String deleteClothes(String code) {
        Clothes deleted = findClothes(code);
        clothesRepository.delete(deleted);
        return "Eliminado correctamente";
    }

    @Override
    public List<Clothes> findAllBySize(String size) {
        return clothesRepository.findAllBySize(size);
    }

    @Override
    public List<Clothes> findAllByName(String name) {
        return clothesRepository.findAllByNameContainingIgnoreCase(name);
    }
}
