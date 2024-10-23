package ar.com.mercadolibre.seguros.repository;

import ar.com.mercadolibre.seguros.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    @Query("select v.licensePlate from Vehicle v")
    List<String> getAllLicensePlates();

    @Query("select v.licensePlate, v.brand from Vehicle v ORDER BY v.year")
    List<Object[]> getVehicleSortedByYear();

    @Query("select v.licensePlate from Vehicle v where v.wheels > 4 and v.year = YEAR(CURRENT_DATE)")
    List<String> getLicensePlateWheelsAndYear();

    @Query("select v.licensePlate, v.brand, v.model from Vehicle v join Claim c on c.vehicle.id = v.id where c.financialLoss > :amount")
    List<Object[]> getLicenseBrandModelByAmountOfClaim(@Param("amount") Double amount);
}
