package org.example.dish;

public class FireSauceDecorator extends DishDecorator {

    public FireSauceDecorator(Dish wrappee) {
        super(wrappee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Огненный соус";
    }

    @Override
    public int getCost() {
        return super.getCost() + 10;
    }
}