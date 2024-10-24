package ar.com.mercadolibre.clothes.repository;

import ar.com.mercadolibre.clothes.entity.Clothes;
import ar.com.mercadolibre.clothes.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ISalesRepository extends JpaRepository<Sales,Long>{
    @Query("select s.clothes from Sales s where s.date = :date")
    List<Clothes> findAllClothesByDate(LocalDate date);

    @Query("select s.clothes from Sales s where s.id = :id")
    List<Clothes> findAllClothesFromSale(Long id);
}
