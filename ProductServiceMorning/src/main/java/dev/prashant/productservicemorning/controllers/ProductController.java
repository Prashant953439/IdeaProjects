package dev.prashant.productservicemorning.controllers;

import dev.prashant.productservicemorning.dtos.CreateProductRequestDto;
import dev.prashant.productservicemorning.models.Category;
import dev.prashant.productservicemorning.models.Product;
import dev.prashant.productservicemorning.services.ProductService;
import dev.prashant.productservicemorning.services.SelfProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(@Qualifier ("SelfProductService") ProductService productService){
        this.productService = productService;
    }
    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto request){
            return productService.createProduct(
                    request.getTitle(),
                    request.getDescription(),
                    request.getCategory(),
                    request.getPrice(),
                    request.getImage()
            );
    }
    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long productId){
        return productService.getSingleProduct(productId);
    }

    @GetMapping("/products")
    public ArrayList<Product> getAllProduct(){
        return productService.getAllProduct();

    }
    @PostMapping("/products/update")
    public void updateProduct(){

    }
    @GetMapping("/products/categories")
    public List<Category> getCategory(){
        return productService.getCategory();
    }
    @GetMapping("/products/category/{category}")
    public List<Product> getProduct(@PathVariable("category")String category) {
        return productService.getProduct(category);
    }
    @DeleteMapping("/products/{id}")
    public Product deleteProduct(@PathVariable("id") Long ProductId){
        return productService.deleteProduct(ProductId);
    }

}


