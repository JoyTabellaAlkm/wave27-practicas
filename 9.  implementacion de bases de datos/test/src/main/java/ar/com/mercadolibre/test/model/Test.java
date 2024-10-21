package ar.com.mercadolibre.test.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tests")
public class Test {

   @Id
    private Long id;

   private String description;

   @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
   private Set<TestCase> cases;

}
