package com.cw3;

import java.util.ArrayList;

public class Storage {
    private final int deliveryTime; // In hours.
    private final ArrayList<Product> products = new ArrayList<>();

    public Storage(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Product findByName(String name) {
        for (int i = 0; i < products.size(); ++i) {
            if (products.get(i).getName().equals(name)) {
                return products.get(i);
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        Product pr = findByName(product.getName());
        if (pr != null) {
            pr.increaseQuantity(product.getQuantity());
        } else {
            products.add(product);
        }
    }

    public int isAvailable(String name, int quantity) {
        Product pr = findByName(name);
        int avail = 0;
        if (pr != null) {
            avail = pr.isAvailable(quantity);
        }
        return avail;
    }

    public int sell(String name, int quantity) {
        Product pr = findByName(name);
        if (pr == null) {
            throw new RuntimeException("Check product availability first!");
        }
        return pr.sell(quantity);
    }

    public int getDeliveryTime() {
            return deliveryTime;
        }
    public ArrayList<Product> getProducts() {
        return products;
    }

    public void inventory() {
        int count=0;
        System.out.print("  Products: \n");
        for (Product product : products) {
            ++count;
            System.out.print("  " + count + ". " + product.getName() + " quantity " + product.getQuantity() + "\n");
        }
    }

}
