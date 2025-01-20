package dev.prashant.productservicemorning.services;

import dev.prashant.productservicemorning.dtos.CreateProductRequestDto;
import dev.prashant.productservicemorning.dtos.FakeStoreProductDto;
import dev.prashant.productservicemorning.models.Category;
import dev.prashant.productservicemorning.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public Product getSingleProduct(Long productId) {
        FakeStoreProductDto fakeStoreProduct = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDto.class
        );

        return fakeStoreProduct.toProduct();
    }

    @Override
    public List<Product> getProduct(String category) {
        List<Product> listProduct = new ArrayList<Product>();
        List<LinkedHashMap<String,String>> ListFakeStoreProductDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products/category/"+category, List.class);
        for(LinkedHashMap<String,String> linkedHashMap : ListFakeStoreProductDtos)
        {
            Product tempProduct = new Product();
            tempProduct.setId(Long.parseLong(String.valueOf(linkedHashMap.get("id"))));
            tempProduct.setDescription(linkedHashMap.get("description"));
            tempProduct.setTitle(linkedHashMap.get("title"));
            tempProduct.setPrice(Double.parseDouble(String.valueOf(linkedHashMap.get("price"))));
            Category tempCategory = new Category();
            tempCategory.setTitle(linkedHashMap.get("Category"));
            tempProduct.setCategory(tempCategory);
            tempProduct.setImageUrl(linkedHashMap.get("image"));
            listProduct.add(tempProduct);
        }
        return listProduct;
    }

    @Override
    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> listProduct = new ArrayList<>();
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products", FakeStoreProductDto[].class
        );
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            FakeStoreProductDto tempfakestore = new FakeStoreProductDto();
            tempfakestore.setId(fakeStoreProductDto.getId());
            tempfakestore.setImage(fakeStoreProductDto.getImage());
            tempfakestore.setDescription(fakeStoreProductDto.getDescription());
            tempfakestore.setPrice(fakeStoreProductDto.getPrice());
            tempfakestore.setCategory(fakeStoreProductDto.getCategory());
            listProduct.add(tempfakestore.toProduct());
        }

        return listProduct;
    }


    @Override
    public Product createProduct(String title,
                                 String description,
                                 String category,
                                 double price,
                                 String image) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(image);
        fakeStoreProductDto.setDescription(description);
        FakeStoreProductDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fakeStoreProductDto,
                FakeStoreProductDto.class
        );
        return response.toProduct();
    }

    @Override
    public List<Category> getCategory() {
        List<String> fakeStoreCategoryDtolist = restTemplate.getForObject(
                "https://fakestoreapi.com/products/categories", List.class);
        List<Category> CategoryList = new ArrayList<>();
        for (String fakestorecategory : fakeStoreCategoryDtolist) {
            Category tempcategory = new Category();
            tempcategory.setTitle(fakestorecategory);
            CategoryList.add(tempcategory);
        }
        return CategoryList;
    }

    @Override
    public Product deleteProduct(Long ProductId) {
        Map<String,String> params = new HashMap<>();
        params.put("id",ProductId.toString());
        Product product = getSingleProduct(ProductId);
        restTemplate.delete("https://fakestoreapi.com/products/" + ProductId,params);
        return product;
    }
}
