package com.example.demo.entity;

public class Product {
    private Long id;
    private String type;
    private String name;
    private String color;
    private String manufacturer;
    private Long stock;
    private String material;
    private String size;

    public Product() {

    }

    public Product(Long id, String type, String name, String color, String manufacturer, Long stock, String material, String size) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.color = color;
        this.manufacturer = manufacturer;
        this.stock = stock;
        this.material = material;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
