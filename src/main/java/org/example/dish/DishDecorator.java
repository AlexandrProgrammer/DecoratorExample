package org.example.dish;

public abstract class DishDecorator implements Dish {
    protected final Dish wrappee;

    public DishDecorator(Dish wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public String getDescription() {
        return wrappee.getDescription();
    }

    @Override
    public int getCost() {
        return wrappee.getCost();
    }
}