package dev.prashant.productservicemorning.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Product extends BaseModel{
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Category category;

}
