package com.example.segurovehiculos.repository;

import com.example.segurovehiculos.dto.VehiculoPatenteMarcaDTO;
import com.example.segurovehiculos.dto.VehiculoPatenteMarcaModeloDTO;
import com.example.segurovehiculos.dto.VehiculoSiniestro;
import com.example.segurovehiculos.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehiculo, Long> {
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> getAllPatentes();

    @Query("SELECT patente, marca FROM Vehiculo ORDER BY anioFabricacion")
    List<VehiculoPatenteMarcaDTO> getPatenteMarcaOrderByAnioFabricacion();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas >= 4 AND v.anioFabricacion = YEAR(current_date)")
    List<String> getPatentesMayorIgualCuatroRuedasAnioActual();

    @Query("SELECT v.patente, v.marca, v.modelo FROM Vehiculo v WHERE (SELECT COUNT(s) FROM v.siniestros s WHERE s.perdidaEconomica > 10000) > 0")
    List<VehiculoPatenteMarcaModeloDTO> getVehiculosConSiniestrosPerdidaEconomicaMayorDiezMil();

    @Query("SELECT v.patente, v.marca, v.modelo, SUM(s.perdidaEconomica) FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > 10000 GROUP BY v.id")
    List<VehiculoSiniestro> getVehiculosConSiniestrosPerdidaEconomicaMayorDiezMilSumaPerdidaEconomica();
}
