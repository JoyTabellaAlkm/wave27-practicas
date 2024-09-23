package ar.com.autosusados.autosusados.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class AutoUsados {
    private Long id =0L;
    private String brand;
    private String model;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date manufacturingDate;
    private String numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private Integer countOfOwners;
    private List<Servicio> services;

    public AutoUsados(String brand, String model, Date manufacturingDate, String numberOfKilometers, Integer doors, Double price, String currency, Integer countOfOwners, List<Servicio> services) {
        this.id = incrementarId();
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.countOfOwners = countOfOwners;
        this.services = services;
    }

    private Long incrementarId() {
        return this.id++;
    }
}
