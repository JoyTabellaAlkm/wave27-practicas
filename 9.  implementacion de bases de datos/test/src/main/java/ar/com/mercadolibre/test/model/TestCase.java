package ar.com.mercadolibre.test.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "test_case")
@Data
public class TestCase {

    @Id
    @Column(name = "id_case")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCase;

    private String description;

    private Boolean tested;

    private Boolean passed;

    @Column(name = "numer_of_tries")
    private Integer numberTries;

    @Column(name = "last_update")
    private LocalDate lastUpdate;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    public void update(TestCase update){
        this.description = update.getDescription() != null ? update.getDescription() : this.description;
        this.tested = update.getTested() != null ? update.getTested() : this.tested;
        this.passed = update.getPassed() != null ? update.getPassed() : this.passed;
        this.numberTries = update.getNumberTries() != null ? update.getNumberTries() : this.numberTries;
        this.lastUpdate = update.getLastUpdate() != null ? update.getLastUpdate() : this.lastUpdate;

    }
}
