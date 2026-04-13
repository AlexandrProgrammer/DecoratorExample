package org.example.dish;

public abstract class DishDecorator implements org.example.dish.Dish {
    private final org.example.dish.Dish wrappee;

    public DishDecorator(org.example.dish.Dish wrappee) {
        this.wrappee = wrappee;
    }

    protected org.example.dish.Dish Wrappee() {
        return wrappee;
    }
}