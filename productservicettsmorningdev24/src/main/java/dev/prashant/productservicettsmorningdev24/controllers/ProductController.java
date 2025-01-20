package dev.prashant.productservicettsmorningdev24.controllers;

import dev.prashant.productservicettsmorningdev24.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private ProductService productService;

    ProductController(@Qualifier("SelfProductService") ProductService productService) {
        this.productService = productService;
    }



}
