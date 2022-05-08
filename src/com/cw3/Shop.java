package com.cw3;

import java.util.HashMap;

public class Shop {
        private String name;
        private final Storage local = new Storage(0);
        private final Storage warehouse1 = new Storage(10);
        private final Storage warehouse2 = new Storage(24);
        private int maxDeliveryTime;

        private void setMaxDeliveryTime(int newTime) {
            if (newTime > maxDeliveryTime) {
                maxDeliveryTime = newTime;
            }

        }

        public Shop(String name) {
            this.name = name;
            maxDeliveryTime = 0;
        }

        public String getName() {
            return name;
        }

        public Storage getLocalWarehouse() {
            return local;
        }

        public Storage getWarehouse1() {
            return warehouse1;
        }

        public Storage getWarehouse2() {
            return warehouse2;
        }

        public int isAvailable(String name, int quantity) {
            int quant = quantity;
            int avail = local.isAvailable(name, quant);
            quant -= avail;
            setMaxDeliveryTime(local.getDeliveryTime());
            if (quant > 0) {
                avail = warehouse1.isAvailable(name, quant);
                quant -= avail;
                setMaxDeliveryTime(warehouse1.getDeliveryTime());
                if(quant > 0) {
                    avail = warehouse2.isAvailable(name, quant);
                    quant -= avail;
                    setMaxDeliveryTime(warehouse2.getDeliveryTime());
                }
            }
            return quantity > quant ? quantity : quant;
        }

        public int getDeliveryTime(String name, int quantity) {
            if (isAvailable(name, quantity) > 0) {
                return maxDeliveryTime;
            } else {
                throw new RuntimeException("Check product availability first!");
            }

        }

        public Product getProduct(String name) {
            Product pr = local.findByName(name);
            if (pr == null) {
                pr = warehouse1.findByName(name);
                if (pr == null) {
                    pr = warehouse2.findByName(name);
                }
            }
            return pr;
        }

        public void sell(String name, int quantity) {
            int avail = local.sell(name, quantity);
            quantity -= avail;
            if (quantity > 0) {
                avail = warehouse1.sell(name, quantity);
                quantity -= avail;
                if(quantity > 0) {
                    avail = warehouse2.sell(name, quantity);
                    quantity -= avail;
                }
            }
            if (quantity > 0) {
                throw new RuntimeException("Not enough product! Check availability first!");
            }
        }
    public void inventory() {
        String bar = "==============================================================\n";
        HashMap<String, Integer> allProducts = new HashMap<>();
        String key="";
        int count = 0;

        System.out.print("\n  INVENTORY of Local Storage: \n");
        System.out.print(bar);
        local.inventory();
        System.out.print("\n  INVENTORY of Warehouse 1: \n");
        System.out.print(bar);
        warehouse1.inventory();
        System.out.print("\n  INVENTORY of Warehouse 2: \n");
        System.out.print(bar);
        warehouse2.inventory();


        for (Product product : local.getProducts()) {
            key = product.getName();
            Integer quantity = allProducts.containsKey(key) ? allProducts.get(key) : 0;
            allProducts.put(key, quantity + product.getQuantity());
        }
        for (Product product : warehouse1.getProducts()) {
            key = product.getName();
            Integer quantity = allProducts.containsKey(key) ? allProducts.get(key) : 0;
            allProducts.put(key, quantity + product.getQuantity());
            }
        for (Product product : warehouse2.getProducts()) {
            key = product.getName();
            Integer quantity = allProducts.containsKey(key) ? allProducts.get(key) : 0;
            allProducts.put(key, quantity + product.getQuantity());
                }

        System.out.print("\n  TOTAL:\n");
        System.out.print(bar);
        for (String name : allProducts.keySet()) {
            ++count;
            System.out.print("" + count + ". " + name + " quantity " + allProducts.get(name) + "\n");
            }
        }

}
