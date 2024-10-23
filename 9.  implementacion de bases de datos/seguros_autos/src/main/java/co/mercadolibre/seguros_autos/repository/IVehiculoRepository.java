package co.mercadolibre.seguros_autos.repository;

import co.mercadolibre.seguros_autos.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {
    @Query("SELECT v.patente FROM Vehiculo AS v")
    List<String> getPatentes();

    @Query("SELECT v.patente, v.marca FROM Vehiculo AS v ORDER BY v.anioFabricacion")
    List<Object[]> getAllPatentesAndMarcaOrderByAnioFabricacion();

    @Query("SELECT v.patente FROM Vehiculo AS v WHERE v.cantidadRuedas > 4 AND v.anioFabricacion = YEAR(CURRENT_DATE())")
    List<String> getPatentesByCantidadRuedasAndAnioFabricacionCurrentYear();

    @Query("SELECT v.patente, v.marca, v.modelo FROM Vehiculo AS v INNER JOIN Siniestro AS s ON v.id = s.vehiculo.id WHERE s.perdidaEconomica > 10000")
    List<Object[]> getVehiculosByPerdidaEconomicaAbove10000();

    @Query("SELECT v.patente AS matricula, v.marca, v.modelo, SUM(s.perdidaEconomica) AS perdidaTotal FROM Vehiculo AS v INNER JOIN Siniestro AS s ON v.id = s.vehiculo.id WHERE s.perdidaEconomica > 10000 GROUP BY v.patente, v.marca, v.modelo")
    List<Object[]> getVehiculosByPerdidaEconomicaAbove10000Agrupada();

}

