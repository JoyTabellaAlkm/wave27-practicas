package ar.com.mercadolibre.seguros.repository;

import ar.com.mercadolibre.seguros.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Integer> {
}
