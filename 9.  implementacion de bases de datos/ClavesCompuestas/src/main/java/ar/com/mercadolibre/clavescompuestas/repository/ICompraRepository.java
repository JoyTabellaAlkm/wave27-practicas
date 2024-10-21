package ar.com.mercadolibre.clavescompuestas.repository;

import ar.com.mercadolibre.clavescompuestas.dto.CompraItemDTO;
import ar.com.mercadolibre.clavescompuestas.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICompraRepository extends JpaRepository<Compra,Long> {

    @Query("SELECT c, i " +
            "FROM Compra c " +
            "JOIN c.items i")
    List<Object[]> findCompraWithItems();
}
