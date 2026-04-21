package org.example.dish;

public class FireSauceDecorator extends DishDecorator {

    public FireSauceDecorator(Dish wrappee) {
        super(wrappee);
    }

    @Override
    public String getDescription() {
        return wrappee.getDescription() + " + Огненный соус";
    }

    @Override
    public int getCost() {
        return wrappee.getCost() + 10;
    }
}