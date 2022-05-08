package com.cw3;

import java.util.ArrayList;
import java.util.UUID;

public class ShoppingCart {
    private static class CartProduct {
       public String name;
        public int quantity;
        public CartProduct() {
            quantity = 0;
        }
    }
    private int id;
    Shop shop;
    private final ArrayList<Product> products = new ArrayList<>();

    private static int generateID() {
        String id = "" + UUID.randomUUID();
        int uid = id.hashCode();
        String str = "" + uid;
        id = str.replaceAll("-", "");
        return Integer.parseInt(id);
    }

    public ShoppingCart(Shop shop) {
        id = generateID();
        this.shop = shop;
    }

    public void addToCart(String name, int quantity) {
        if (name == null || name.isEmpty() || quantity == 0) {
            throw new RuntimeException("Product must have name and non-zero quantity!");
        }
        int avail = shop.isAvailable(name, quantity);
        if (avail < quantity) {
            throw new RuntimeException("Not enough product! Check availability first!");
        }
        if (avail > 0) {
            Product product = shop.getProduct(name);
            int deliveryTime = 0;

            if (product != null) {
                Product newProduct = new Product(product);
                newProduct.setQuantity(quantity);

                products.add(newProduct);

            } else {
                throw new RuntimeException("Product not available!");
            }
        }
    }

    public double totalPrice() {
        double totalPrice = 0;
        for(Product product : products) totalPrice += product.getPrice() * product.getQuantity();
        return totalPrice;
    }

    public int getTotalDeliveryTime() {
        int totalTime = 0;
        int productTime = 0;
        for (Product product : products) {
            productTime = shop.getDeliveryTime(product.getName(), product.getQuantity());
            if (productTime > totalTime) totalTime = productTime;
        }
        return totalTime;
    }

    public void sell() {
        for (Product product : products) {
            shop.sell(product.getName(), product.getQuantity());
        }
    }
}
