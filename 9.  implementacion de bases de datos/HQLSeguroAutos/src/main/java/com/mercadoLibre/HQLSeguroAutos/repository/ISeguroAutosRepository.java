package com.mercadoLibre.HQLSeguroAutos.repository;
import com.mercadoLibre.HQLSeguroAutos.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ISeguroAutosRepository extends JpaRepository<Vehiculo, Long> {
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> getAllPatentes();

    @Query("SELECT v FROM Vehiculo v WHERE v.patente = :patente")
    Optional<Vehiculo> findByPatente(String patente);

    @Query("SELECT v FROM Vehiculo v ORDER BY v.anioFabricacion")
    List<Vehiculo> getPatenteAndMarcaOrderByAnio();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas = 4 AND v.anioFabricacion = year(sysdate())")
    List<String> getPatenteByCantidadRuedasAndAnioFabricacion();

    @Query("SELECT v FROM Vehiculo v INNER JOIN v.siniestrosDenunciados s WHERE s.perdida > 10000")
    List<Vehiculo> getAllBySiniestroPerdida();
}
