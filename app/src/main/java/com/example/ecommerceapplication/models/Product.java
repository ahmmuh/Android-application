package com.example.ecommerceapplication.models;

public class Product {
    private long id;
    private String name;
    private String ProductImage;
    private double price;
    private String description;


    public Product(long id, String name,
                   String productImage, double price,
                   String description) {
        this.id = id;
        this.name = name;
        ProductImage = productImage;
        this.price = price;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProductImage() {
        return ProductImage;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
