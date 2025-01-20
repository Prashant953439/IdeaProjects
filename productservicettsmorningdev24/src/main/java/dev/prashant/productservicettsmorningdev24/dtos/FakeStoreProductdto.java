package dev.prashant.productservicettsmorningdev24.dtos;

import dev.prashant.productservicettsmorningdev24.models.Category;
import dev.prashant.productservicettsmorningdev24.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FakeStoreProductDto {
    Long id;
    String title;
    long price;
    String description;
    String image;
    String category;

    public Product toProduct(){
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImage(image);
        Category productCategory = new Category();
        productCategory.setTitle(category);
        product.setCategory(productCategory);
        return product;
    }
}
