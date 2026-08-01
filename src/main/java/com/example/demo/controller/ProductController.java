package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductServices productServices;

    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }
    @GetMapping
    public List<Product> getAllProduct() {

        return productServices.getListProduct();

    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable long id) {
        return productServices.getProductById(id);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable long id, @RequestBody(required = false) Product productAlreadyChange){
        return productServices.updateProduct(id,productAlreadyChange);
    }
}
