package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductServices productServices;

    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProduct() {
        return ResponseEntity.ok(productServices.getListProduct());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable long id) {
        ProductDTO productDTO = productServices.getProductById(id);
        if(productDTO==null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(productDTO);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product) {
        ProductDTO createdProduct = productServices.createProduct(product);
        URI location = URI.create("/api/product/" + product.getId());

        return ResponseEntity.created(location).body(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable long id, @RequestBody ProductDTO dtoChanges){
       ProductDTO updateProduct = productServices.updateProduct(id, dtoChanges);
       if(updateProduct==null){
           return ResponseEntity.notFound().build();
       }
        return ResponseEntity.ok(updateProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean deleted = productServices.deleteProduct(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}

