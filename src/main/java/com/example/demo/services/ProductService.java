package com.example.demo.services;

import com.example.demo.dtos.ProductDto;
import com.example.demo.models.Categories;
import com.example.demo.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//Interface is created so that controllers and services are independent of each other
@Service
public class ProductService implements iProductService {

    private RestTemplateBuilder restTemplateBuilder;

    public ProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }
    @Override
    public String getAllProducts(){return null;}
    //This method is returning a tring value but we want to return a product object to the client
//    @Override
//    public String getsingleProduct(long productId){
//        RestTemplate restTemplate=restTemplateBuilder.build();
//       ProductDto productDto= restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",
//               ProductDto.class,productId).getBody();
//        return productDto.toString();
//    }

    @Override
    public Product getsingleProduct(long productId){
        RestTemplate restTemplate=restTemplateBuilder.build();
       ProductDto productDto= restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",
               ProductDto.class,productId).getBody();

       Product product=new Product();
       product.setId(productDto.getId());
       product.setTitle(productDto.getTitle());
       product.setPrice(productDto.getPrice());
        Categories category=new Categories();
        category.setName(productDto.getCategory());
        product.setImageUrl(productDto.getImage());
        return product;
    }
    @Override
    public String addnewProduct(ProductDto productDto){return null;}
    @Override
    public String updateproduct(long productId){return  null;}
    @Override
    public String deleteProduct(long productId){return null;}
}
