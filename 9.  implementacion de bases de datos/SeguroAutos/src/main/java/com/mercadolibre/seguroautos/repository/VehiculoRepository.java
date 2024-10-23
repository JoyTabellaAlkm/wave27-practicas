package com.mercadolibre.seguroautos.repository;

import com.mercadolibre.seguroautos.dto.PatenteYMarcaResponseDto;
import com.mercadolibre.seguroautos.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("select v from Vehiculo v" )
    List<Vehiculo> findAll();

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String>  findAllPatentes();

    @Query("SELECT v.patente, v.marca FROM Vehiculo v ORDER BY v.anioFabricacion")
    List<Object[]> findAllByPatenteAndMarca();

    @Query("select v.patente from Vehiculo v where v.cantidadRuedas > 4 AND v.anioFabricacion LIKE '2024'" )
    List<String> findAllPatentesVehiculosPorRuedasYAnio();

    @Query("SELECT v.patente, v.marca, v.modelo FROM Vehiculo v " +
            "JOIN v.siniestros s " +
            "WHERE s.perdidaEconomica > 10000")
    List<Object[]> findVehiculosConSiniestroMayorA10000();


    @Query("SELECT v.patente, v.marca, v.modelo, SUM(s.perdidaEconomica) as perdidaTotal " +
            "FROM Vehiculo v JOIN v.siniestros s " +
            "WHERE s.perdidaEconomica >10000 " +
            "GROUP BY v.patente, v.marca, v.modelo ")
    List<Object[]> findVehiculosConSiniestroMayorA10000ConSumaPerdida();
}
