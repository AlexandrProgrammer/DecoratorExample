package org.example.dish;

public class SnowBerriesDecorator extends DishDecorator {

    public SnowBerriesDecorator(Dish wrappee) {
        super(wrappee);
    }

    @Override
    public String getDescription() {
        return wrappee.getDescription() + " + Снежные ягоды";
    }

    @Override
    public int getCost() {
        return wrappee.getCost() + 5;
    }
}