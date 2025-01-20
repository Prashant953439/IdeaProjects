package dev.prashant.productservicettsmorningdev24.services;

import dev.prashant.productservicettsmorningdev24.dtos.FakeStoreProductDto;
import dev.prashant.productservicettsmorningdev24.exceptions.ProductNotFoundException;
import dev.prashant.productservicettsmorningdev24.models.Category;
import dev.prashant.productservicettsmorningdev24.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class FakeStoreProductService implements ProductService {
    private  RestTemplate restTemplate;
    private String category;

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    @Override
    public Product createProduct(String title, String description, String Category, Long price, String image) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(image);
        FakeStoreProductDto response = restTemplate.postForObject("https://fakestoreapi.com/products", fakeStoreProductDto, FakeStoreProductDto.class);
        return response.toProduct();
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public List<Category> getCategories() {
        return null;
    }

    @Override
    public List<Product> getProducts(String Category) {
        return null;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Long productId) throws ProductNotFoundException {
        return null;
    }

}
    @Override
    public Product createProduct(String title, String description, String Category, Long price, String image) {
        return null;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public List<Category> getCategories() {
        return null;
    }

    @Override
    public List<Product> getProducts(String Category) {
        return null;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Long productId) throws ProductNotFoundException {
        return null;
    }


}
