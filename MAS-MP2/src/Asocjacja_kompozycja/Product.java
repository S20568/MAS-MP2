package Asocjacja_kompozycja;

/*
    @author Jakub Slusarski, s20568, 20c
*/

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable {

    String name, producer, sku, description;
    int price;
    long serialNumber;
    boolean isAvailable;
    List<Order> orderList = new ArrayList<>();

    public Product(String name, String producer, String description, String sku, long serialNumber, int price, boolean isAvailable, int quantity) {
        this.name = name;
        this.producer = producer;
        this.description = description;
        this.sku = sku;
        this.serialNumber = serialNumber;
        this.price = price;
        this.isAvailable = isAvailable;
        ProductInventory.addToProductInventory(quantity, this);
    }

    public String getSku() {
        return sku;
    }

    @Override
    public String toString() {
        return "Product name: " + name + ", price: " + price;
    }
}