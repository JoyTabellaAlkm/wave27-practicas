package ar.com.mercadolibre.empresaseguros.repository;

import ar.com.mercadolibre.empresaseguros.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    // Listar las patentes de todos los vehículos registrados.
    @Query("SELECT v.patente" +
            " FROM Vehiculo v")
    List<String> getVehiculoByPatente();

    // Listar la patente y la marca de todos los vehículos ordenados
    // por año de fabricación.

    @Query("SELECT v.patente, v.marca " +
            "FROM Vehiculo v " +
            "ORDER BY v.anioFabricacion asc")
    List<Object[]> getVehiculoByPatenteAndMarcaOrderByAnioFabricacion();

    // Listar la patente de todos los vehículos que tengan más de
    // cuatro ruedas
    // y hayan sido fabricados en el corriente año.
    @Query("SELECT v.patente " +
            "FROM Vehiculo v " +
            "WHERE v.cantidadRuedas > 4 " +
            "AND v.anioFabricacion = YEAR(CURRENT_DATE) ")
    List<String> getVehiculoByPatenteAndCantidadRuedasAfterFour();

    // Listar la matrícula, marca y modelo de todos los vehículos
    // que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @Query("SELECT v.patente, v.marca, v.modelo " +
            "FROM Vehiculo v " +
            "JOIN Siniestro s ON s.vehiculo = v " +
            "WHERE s.perdidaEconomica > 10000")
    List<Object[]> getVehiculoBySiniestros();

    // Listar la matrícula, marca y modelo de todos los vehículos
    // que hayan tenido un siniestro con pérdida mayor de 10000 pesos
    // y mostrar a cuánto ascendió la pérdida total de todos ellos.
    @Query("SELECT v.patente, v.marca, v.modelo, SUM(s.perdidaEconomica) " +
            "FROM Vehiculo v " +
            "JOIN Siniestro s ON s.vehiculo = v " +
            "WHERE s.perdidaEconomica > 10000 " +
            "GROUP BY v.patente, v.marca, v.modelo")
    List<Object[]> getVehiculoBySiniestrosAndPerdida();

}
