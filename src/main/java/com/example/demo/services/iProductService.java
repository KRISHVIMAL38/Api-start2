package com.example.demo.services;

import com.example.demo.dtos.ProductDto;
import com.example.demo.models.Product;

public interface iProductService {
    String getAllProducts();

    Product getsingleProduct(long productId);

    String addnewProduct(ProductDto productDto);

    String updateproduct(long productId);

    String deleteProduct(long productid);
}
