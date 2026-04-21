package org.example.dish;

public class NordicRagu implements Dish {

    @Override
    public String getDescription() {
        return "Нордское рагу";
    }

    @Override
    public int getCost() {
        return 50;
    }
}