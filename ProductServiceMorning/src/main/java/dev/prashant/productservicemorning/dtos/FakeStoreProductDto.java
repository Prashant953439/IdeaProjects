package dev.prashant.productservicemorning.dtos;

import dev.prashant.productservicemorning.models.Category;
import dev.prashant.productservicemorning.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FakeStoreProductDto {

    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;


    public Product toProduct(){
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImageUrl(image);

        Category productCategory =  new Category();
        productCategory.setTitle(category);

        product.setCategory(productCategory);

        return product;
    }
}
