package org.example.dish;

public abstract class DishDecorator implements Dish {
    protected final Dish wrappee;

    public DishDecorator(Dish wrappee) {
        this.wrappee = wrappee;
    }

    protected Dish Wrappee() {
        return wrappee;
    }
}