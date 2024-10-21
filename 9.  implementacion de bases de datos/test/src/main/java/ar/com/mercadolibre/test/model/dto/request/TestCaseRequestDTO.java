package ar.com.mercadolibre.test.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TestCaseRequestDTO {

    private String description;

    private Boolean tested;

    private Boolean passed;

    @JsonProperty("number_of_tries")
    private Integer numberTries;

    @JsonProperty("last_update")
    private LocalDate lastUpdate;

}
