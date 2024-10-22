package com.mercadolibre.seguroautos.repository;

import com.mercadolibre.seguroautos.Query.VehiculoSiniestroCostoInfo;
import com.mercadolibre.seguroautos.Query.VehiculoSiniestroInfo;
import com.mercadolibre.seguroautos.dto.PatenteRespondeDTO;
import com.mercadolibre.seguroautos.dto.VehiculoSiniestroInfoDTO;
import com.mercadolibre.seguroautos.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    // 0
    @Query(nativeQuery = true, value= "select v from Vehiculo v" )
    List<Vehiculo> findAll();

    // 1
    @Query(nativeQuery = true, value="SELECT v.patente FROM Vehiculo v")
    List<String>  findAllPatentes();

    //2
    @Query(value = "SELECT v FROM vehiculo v order by v.anioFabricacion ASC")
    List<Vehiculo> findAllByPatenteAndMarca();

    //3
    @Query(value= "select v.patente from vehiculo v where v.cantidadRuedas > 4 AND v.anioFabricacion LIKE '2024' " )
    List<String> findAllByCantidadRuedasAndAnioFabricacion();

    //4
    @Query("SELECT v.patente, v.marca, v.modelo " +
            "FROM vehiculo v JOIN v.siniestros s " +
            "WHERE s.perdidaEconomica > 10000")
    List<VehiculoSiniestroInfo> findVehiculosConSiniestroMayorA10000();

    //5
    @Query(value = "SELECT new com.mercadolibre.seguroautos.Query.VehiculoSiniestroCostoInfo(v.patente, v.marca, v.modelo, SUM(s.perdidaEconomica)) " +
            "FROM vehiculo v JOIN v.siniestros s " +
            "WHERE s.perdidaEconomica > 10000 " +
            "GROUP BY v.patente, v.marca, v.modelo")
    List<VehiculoSiniestroCostoInfo> findVehiculosConSiniestroMayorA10000Total();

}
