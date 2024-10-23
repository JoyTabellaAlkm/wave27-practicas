package ar.com.mercadolibre.clothes.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Document(indexName = "sales")
public class Sales {
    @Id
    private String id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
    private BigDecimal total;
    private String paymentMethod;
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Clothes> clothes;
}
