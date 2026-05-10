package org.example.dish;

public class SnowBerriesDecorator extends DishDecorator {

    public SnowBerriesDecorator(Dish wrappee) {
        super(wrappee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Снежные ягоды";
    }

    @Override
    public int getCost() {
        return super.getCost() + 5;
    }
}