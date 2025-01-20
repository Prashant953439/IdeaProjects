package dev.prashant.productservicettsmorningdev24.services;

import dev.prashant.productservicettsmorningdev24.exceptions.ProductNotFoundException;
import dev.prashant.productservicettsmorningdev24.models.Category;
import dev.prashant.productservicettsmorningdev24.models.Product;


import java.util.List;

public interface ProductService{
    Product createProduct(String title, String description, String Category, Long price, String image);

    Product getSingleProduct(Long productId) throws ProductNotFoundException;

    List<Product> getProducts();

    List<Category> getCategories();

    List<Product> getProducts(String Category);

    Product updateProduct(Long productId, Product product);

    Product deleteProduct(Long productId) throws ProductNotFoundException;
}
