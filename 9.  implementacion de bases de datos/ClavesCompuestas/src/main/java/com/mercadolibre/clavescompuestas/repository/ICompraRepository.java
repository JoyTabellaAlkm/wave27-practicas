package com.mercadolibre.clavescompuestas.repository;

import com.mercadolibre.clavescompuestas.entity.Compra;
import com.mercadolibre.clavescompuestas.entity.CompraId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompraRepository extends JpaRepository<Compra, CompraId> {

}
