package com.cw3;

// Typy produktów:
enum ProductType {
    Undefined,
    Consumable,
    Entertainment,
    Electronics
}

// Produkt:
public class Product {
    private String name;
    private ProductType productType;
    private double price;
    private int quantity;

    public Product() {
        productType = ProductType.Undefined;
        price = 0.0;
        quantity = 0;
    }

    public Product(String name, ProductType productType, double price, int quantity) {
        setName(name);
        setProductType(productType);
        setPrice(price);
        if (quantity == 0) {
            throw new RuntimeException("No product quantity");
        }
        this.quantity = quantity;
    }

    public Product(Product otherProduct) {
        name = otherProduct.name;
        productType = otherProduct.productType;
        price = otherProduct.price;
        quantity = otherProduct.quantity;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("Product must have a name");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setPrice(double price) {
        if (price == 0.0) {
            throw new RuntimeException("Socialism forbidden");
        }
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }

    public int isAvailable(int quantity) {
        return (this.quantity - quantity) >= 0 ? quantity : this.quantity;
    }

    public int sell(int quantity) {
        this.quantity -= quantity;
        if (this.quantity < 0) {
            quantity += this.quantity;
            this.quantity = 0;
        }
        return quantity;
    }
}
