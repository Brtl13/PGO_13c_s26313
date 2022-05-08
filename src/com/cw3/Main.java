package com.cw3;

public class Main {

    public static void main(String[] args) {
        String bar = "==============================================================\n";
        Shop shop = new Shop("Liquors & Co.");

        Product cigarettes = new Product("Marlboro Gold", ProductType.Consumable, 3.5, 25);
        shop.getLocalWarehouse().addProduct(cigarettes);
        cigarettes = new Product(cigarettes);
        cigarettes.setQuantity(0);
        shop.getWarehouse1().addProduct(cigarettes);
        cigarettes = new Product(cigarettes);
        cigarettes.setQuantity(100);
        shop.getWarehouse2().addProduct(cigarettes);

        Product whiskey = new Product("Jack Daniels Whisky", ProductType.Entertainment, 9.0, 10);
        shop.getLocalWarehouse().addProduct(whiskey);
        whiskey = new Product(whiskey);
        whiskey.setQuantity(200);
        shop.getWarehouse1().addProduct(whiskey);
        whiskey = new Product(whiskey);
        whiskey.setQuantity(700);
        shop.getWarehouse2().addProduct(whiskey);

        Person john = new Person("John", "Doe", 140.0, 0.0);
        Person jane = new Person("Jane","Who", 1.0, 100.0);

        shop.inventory();

        john.makeOrder(shop, "Jack Daniels Whisky", 9);
        john.makeOrder(shop, "Marlboro Gold", 9);

        System.out.print("\n  ORDER SUMMARY\n" + bar + "Customer: " + john.getName() + " " + john.getSurName() + "\n" +
                "Total Price: " + john.getTotalPrice() + "\n" +
                "ETA: " + john.getDeliveryTime() + "\n");
        john.buyByCash();
        System.out.print("\nBalance after purchase:\n" +
                        "Cash: " + john.getMoneyInCash() + "\n" +
                        "Card: " + john.getMoneyOnCard() + "\n"
                        + bar);


        jane.makeOrder(shop, "Marlboro Gold", 20);
        jane.makeOrder(shop, "Jack Daniels Whisky", 2);
        System.out.print("\n  ORDER SUMMARY\n" + bar + "Customer: " + jane.getName() + " " + jane.getSurName() + "\n" +
                "Total Price: " + jane.getTotalPrice() + "\n" +
                "ETA: " + jane.getDeliveryTime() + "\n");
        jane.buyByCard();
        System.out.print("\nBalance after purchase:\n" +
                "Cash: " + jane.getMoneyInCash() + "\n" +
                "Card: " + jane.getMoneyOnCard() + "\n"
                + bar);

        shop.inventory();
        System.out.print(bar + "\nNew Shipment of products has arrived!\n" + bar);
        whiskey.increaseQuantity(1000);
        cigarettes.increaseQuantity(500);
        shop.inventory();
    }
}

