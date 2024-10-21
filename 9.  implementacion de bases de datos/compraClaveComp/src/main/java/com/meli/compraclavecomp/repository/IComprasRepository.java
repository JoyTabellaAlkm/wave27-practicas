package com.meli.compraclavecomp.repository;

import com.meli.compraclavecomp.entity.Compra;
import com.meli.compraclavecomp.entity.CompraKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComprasRepository extends JpaRepository<Compra, CompraKey> {
}
