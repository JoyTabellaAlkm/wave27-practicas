package com.lasperlas.lasperlas.repository.impl;

import com.lasperlas.lasperlas.entity.Joya;
import com.lasperlas.lasperlas.repository.IJoyaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class JoyaRepositoryImpl implements IJoyaRepository {

    private JpaRepository<Joya, Long> jpaRepository;

    @Override
    public void deleteById(Long id) {
        Joya joya = jpaRepository.findById(id).orElse(null);

        if (joya != null) {
            joya.setVentaONo(false);
            jpaRepository.save(joya);
        }
    }
}
