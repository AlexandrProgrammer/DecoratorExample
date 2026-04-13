package org.example.model;

public class Order {
    private final String time;
    private final String name;
    private final int price;

    public Order(String time, String name, int price) {
        this.time = time;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return time + " ; " + name + " ; " + price + " септимов";
    }

}