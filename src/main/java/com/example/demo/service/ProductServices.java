package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServices {
    List<Product> products = new ArrayList<>(List.of(
            // T-SHIRTS
            new Product(1L, "T-Shirt", "Essential Crewneck", "Blue", "Nike", 150L, "Cotton", "M"),
            new Product(2L, "T-Shirt", "Classic Fit Polo", "White", "Tommy Hilfiger", 90L, "Pique Cotton", "L"),
            new Product(3L, "T-Shirt", "Tech Graphic Tee", "Black", "Under Armour", 95L, "Polyester", "S"),
            new Product(4L, "T-Shirt", "Slim Fit V-Neck", "Green", "Lacoste", 65L, "Cotton", "M"),
            new Product(5L, "T-Shirt", "Sport Performance Shirt", "Red", "Puma", 110L, "Polyester", "XL"),
            new Product(6L, "T-Shirt", "Casual Striped Tee", "Gray", "Adidas", 130L, "Cotton", "S"),

            // Jackets
            new Product(7L, "Jacket", "Biker Leather Jacket", "Brown", "Zara", 20L, "Leather", "S"),
            new Product(8L, "Jacket", "Winter Parka", "Olive Green", "Columbia", 15L, "Wool Blend", "XL"),
            new Product(9L, "Jacket", "Rain Windbreaker", "Yellow", "Patagonia", 22L, "Recycled Nylon", "M"),
            new Product(10L, "Jacket", "Thermo Puffer Jacket", "Black", "The North Face", 35L, "Polyester", "L"),
            new Product(11L, "Jacket", "Denim Trucker Jacket", "Navy Blue", "Levi's", 40L, "Denim", "M"),
            new Product(12L, "Jacket", "Casual Blazer", "Gray", "Mango", 18L, "Cotton", "S"),

            // Pants
            new Product(13L, "Pants", "501 Original Jeans", "Navy Blue", "Levi's", 80L, "Denim", "L"),
            new Product(14L, "Pants", "Slim Sweatpants", "Gray", "Puma", 110L, "Polyester", "M"),
            new Product(15L, "Pants", "High-Rise Yoga Leggings", "Purple", "Lululemon", 70L, "Nylon/Spandex", "S"),
            new Product(16L, "Pants", "Waterproof Ski Pants", "Red", "Salomon", 18L, "Synthetic Waterproof", "L"),
            new Product(17L, "Pants", "Straight Fit Chinos", "Black", "Dockers", 60L, "Cotton", "32"),
            new Product(18L, "Pants", "Lightweight Linen Trousers", "Beige", "Zara", 45L, "Linen", "M"),

            // Shoes
            new Product(19L, "Shoes", "Gel-Kayano Running Shoes", "Gray/Orange", "Asics", 50L, "Synthetic Mesh", "42"),
            new Product(20L, "Shoes", "Leather Oxford Dress Shoes", "Black", "Clarks", 30L, "Leather", "41"),
            new Product(21L, "Shoes", "Waterproof Hiking Boots", "Brown", "Timberland", 25L, "Waterproof Leather", "43"),
            new Product(22L, "Shoes", "Chuck Taylor High Tops", "White", "Converse", 120L, "Canvas", "40"),
            new Product(23L, "Shoes", "Suede Casual Sneakers", "Blue", "Adidas", 85L, "Suede", "44"),
            new Product(24L, "Shoes", "Air Sport Sneakers", "Black", "Nike", 60L, "Synthetic Leather", "42"),

            // Underwear
            new Product(25L, "Underwear", "Cotton Stretch Boxers 3-Pack", "Black", "Calvin Klein", 180L, "Cotton", "L"),
            new Product(26L, "Underwear", "Sports Socks 5-Pack", "White", "Decathlon", 300L, "Cotton/Elastane", "41-45"),
            new Product(27L, "Underwear", "Silk Briefs", "Blue", "Intimissimi", 90L, "Silk", "M"),
            new Product(28L, "Underwear", "Microfiber Trunks", "Gray", "Puma", 120L, "Microfiber", "S"),
            new Product(29L, "Underwear", "AIRism Boxer Briefs", "Black", "Uniqlo", 200L, "Polyester/Spandex", "M"),
            new Product(30L, "Underwear", "Lace Bralette", "White", "Tezenis", 150L, "Lace", "S")
    ));


    public List<ProductDTO> getListProduct() {
        List<ProductDTO> allproduct = new ArrayList<>();
        for(Product p: products){
            allproduct.add(new ProductDTO( p.getType(),p.getName(), p.getColor(),p.getSize()));
        }
        return allproduct;
    }



    public ProductDTO getProductById(Long id) {

       Product p= getProductByIdFromProduct(id);
       if (p!= null) {
           return new ProductDTO(p.getType(), p.getName(), p.getColor(), p.getSize());
       }
       return null;
    }
private Product getProductByIdFromProduct(Long id){
        for (Product p: products){
            if (p.getId().equals(id)){
                return p;
            }

        }
        return null;
}

    public ProductDTO createProduct (Product product) {
        products.add(product);
        return new ProductDTO(product.getType(),product.getName(), product.getColor(),product.getSize());
    }


    public ProductDTO updateProduct(Long id, ProductDTO dtoCHanges) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                if (dtoCHanges.getName() != null) {
                    p.setName(dtoCHanges.getName());
                }
                if (dtoCHanges.getType() != null) {
                    p.setType(dtoCHanges.getType());
                }
                if (dtoCHanges.getColor() != null) {
                    p.setColor(dtoCHanges.getColor());
                }
                if (dtoCHanges.getSize() != null) {
                    p.setSize(dtoCHanges.getSize());
                }
                return new ProductDTO(p.getType(),p.getName(), p.getColor(),p.getSize());
            }
        }
        return null;
    }


    public boolean deleteProduct(Long id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                products.remove(p);
                return true;
            }
        }
        return false;
    }
}