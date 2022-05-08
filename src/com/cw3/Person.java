package com.cw3;

import java.util.ArrayList;

public class Person {
    private String name;
    private String surName;
    private double moneyInCash;
    private double moneyOnCard;
    private ShoppingCart currentCart;
    private final ArrayList<ShoppingCart> shoppingHistory = new ArrayList<>();

    public Person() {
        moneyInCash = 0.0;
        moneyOnCard = 0.0;
        currentCart = null;
    }

    public Person(String name, String surName, double moneyInCash, double moneyOnCard) {
        setName(name);
        setSurName(surName);
        setMoneyInCash(moneyInCash);
        setMoneyOnCard(moneyOnCard);
        currentCart = null;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("Person must have name");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurName(String surName) {
        if (surName == null || surName.isEmpty()) {
            throw new RuntimeException("Person must have surname");
        }
        this.surName = surName;
    }

    public String getSurName() {
        return surName;
    }

    public void setMoneyInCash(double moneyInCash) {
        this.moneyInCash = moneyInCash;
    }

    public double getMoneyInCash() {
        return moneyInCash;
    }

    public void setMoneyOnCard(double moneyOnCard) {
        this.moneyOnCard = moneyOnCard;
    }

    public double getMoneyOnCard() {
        return moneyOnCard;
    }

    public void makeOrder(Shop shop, String productName, int quantity) {
        int avail = shop.isAvailable(productName, quantity);
        if (avail > 0) {
            if (currentCart == null) {
                currentCart = new ShoppingCart(shop);
            }
            if (avail == quantity) {
                currentCart.addToCart(productName, quantity);
            }
            else {
                throw new RuntimeException("Product available in smaller quantities!");
            }
        } else {
            throw new RuntimeException("Product not available!");
        }
    }

    public double getTotalPrice() {
        if (currentCart == null) {
            throw new RuntimeException("No price without order");
        }
        return currentCart.totalPrice();
    }
    public int getDeliveryTime() {
        if (currentCart == null) {
            throw new RuntimeException("No delivery time without order");
        }
        return currentCart.getTotalDeliveryTime();
    }

    protected void saveCart() {
        shoppingHistory.add(currentCart);
        currentCart = null;
    }

    public void buyByCard() {
        if (currentCart != null) {
            double price = currentCart.totalPrice();
            if (price <= moneyOnCard) {
                moneyOnCard -= price;
                currentCart.sell();
                saveCart();
            } else {
                throw new RuntimeException("Not enough means of payment on CC!");
            }
        } else {
            throw new RuntimeException("No shopping cart to pay for!");
        }
    }

    public void buyByCash() {
        if (currentCart != null) {
            double price = currentCart.totalPrice();
            if (price <= moneyInCash) {
                moneyInCash -= price;
                currentCart.sell();
                saveCart();
            } else {
                throw new RuntimeException("Not enough little change!");
            }
        } else {
            throw new RuntimeException("No shopping cart to pay for!");
        }
    }
}
