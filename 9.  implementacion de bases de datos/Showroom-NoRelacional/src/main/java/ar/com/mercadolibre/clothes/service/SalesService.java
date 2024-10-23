package ar.com.mercadolibre.clothes.service;

import ar.com.mercadolibre.clothes.entity.Clothes;
import ar.com.mercadolibre.clothes.entity.Sales;
import ar.com.mercadolibre.clothes.repository.ISalesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.StreamSupport;

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
        Iterable<Sales> sales = salesRepository.findAll();
        return StreamSupport.stream(sales.spliterator(), false).toList();
    }

    @Override
    public Sales findSaleById(String number) {
        return salesRepository.findById(number).orElseThrow(()-> new RuntimeException("No encontrado"));
    }

    @Override
    public Sales updateSale(String number, Sales sale) {
        Sales modified = findSaleById(number);
        modified.setDate(sale.getDate());
        modified.setTotal(sale.getTotal());
        modified.setPaymentMethod(sale.getPaymentMethod());
        modified.setClothes(sale.getClothes());

        save(modified);
        return modified;
    }

    @Override
    public String deleteSale(String number) {
        Sales deleted = findSaleById(number);
        salesRepository.delete(deleted);
        return "Eliminado correctamente";
    }

    @Override
    public List<Clothes> findByDate(LocalDate date) {
        Iterable<Sales> clothes = salesRepository.findClothesByDate(date);

        return StreamSupport.stream(clothes.spliterator(), false)
                .map(Sales::getClothes)
                .flatMap(List::stream)
                .toList();
    }

    @Override
    public List<Clothes> findAllClothes(String number) {
        Sales sale = findSaleById(number);
        return sale.getClothes();
    }
}
