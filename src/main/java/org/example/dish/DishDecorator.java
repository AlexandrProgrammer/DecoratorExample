package org.example.dish;

public abstract class DishDecorator implements Dish {
    private final Dish wrappee;

    protected DishDecorator(Dish wrappee) {
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