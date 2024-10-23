package ar.com.mercadolibre.clothes.service;

import ar.com.mercadolibre.clothes.entity.Clothes;
import ar.com.mercadolibre.clothes.entity.Sales;
import ar.com.mercadolibre.clothes.repository.ISalesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SalesService implements ISalesService {
    private final ISalesRepository salesRepository;

    public SalesService(ISalesRepository salesRepository){this.salesRepository=salesRepository;}

    @Override
    public Sales save(Sales sale) {
        return salesRepository.save(sale);
    }

    @Override
    public List<Sales> findAll() {
        return salesRepository.findAll();
    }

    @Override
    public Sales findSaleById(Long number) {
        return salesRepository.findById(number).orElseThrow(()-> new RuntimeException("No encontrado"));
    }

    @Override
    public Sales updateSale(Long number, Sales sale) {
        Sales modified = findSaleById(number);
        modified.setDate(sale.getDate());
        modified.setTotal(sale.getTotal());
        modified.setPaymentMethod(sale.getPaymentMethod());
        modified.setClothes(sale.getClothes());

        save(modified);
        return modified;
    }

    @Override
    public String deleteSale(Long number) {
        Sales deleted = findSaleById(number);
        salesRepository.delete(deleted);
        return "Eliminado correctamente";
    }

    @Override
    public List<Clothes> findByDate(LocalDate date) {
        return salesRepository.findAllClothesByDate(date);
    }

    @Override
    public List<Clothes> findAllClothes(Long number) {
        return salesRepository.findAllClothesFromSale(number);
    }
}
