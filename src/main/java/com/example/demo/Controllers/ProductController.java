package com.example.demo.Controllers;

import com.example.demo.dtos.ProductDto;
import com.example.demo.models.Product;
import com.example.demo.services.ProductService;
import com.example.demo.services.iProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//This controller will always answer products

@RestController
@RequestMapping("/products")
public class ProductController {

    iProductService productService;

    public ProductController(iProductService productService){
        this.productService=productService;
    }


    @GetMapping("")
    public String getAllProducts(){
        return "this is the list of all the products";
    }

//    @RequestMapping("{productId}")
    // We don't want to return String we want to return the Product object
//    public String getSingleProduct(@PathVariable ("productId") long id) {
//        String product =productService.getsingleProduct(id);
//        return product;
//    }

    @RequestMapping("{productId}")
    public Product getSingleProduct(@PathVariable ("productId") long id) {
        Product product =productService.getsingleProduct(id);
        return product;
    }

    @PostMapping()
    public String addNewProduct(@RequestBody ProductDto productDto){
        return "Adding new products " +productDto;
    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable ("productId") long productId){
        return "product updated with the product id =="+productId;
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") long productId){
        return "product deleted with the product id ===="+productId;
    }
}

