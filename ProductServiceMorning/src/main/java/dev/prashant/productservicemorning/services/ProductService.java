package dev.prashant.productservicemorning.services;

import dev.prashant.productservicemorning.models.Category;
import dev.prashant.productservicemorning.models.Product;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
@Service
public interface ProductService {

    Product getSingleProduct(Long productId);

    List<Product> getProduct(String category);
    Product createProduct(String title,
                          String description,
                          String category,
                          double price,
                          String image);
    ArrayList<Product> getAllProduct();
    List<Category> getCategory();

    Product deleteProduct(Long productId);

}
