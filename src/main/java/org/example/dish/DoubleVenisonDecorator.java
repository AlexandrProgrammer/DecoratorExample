package org.example.dish;

public class DoubleVenisonDecorator extends DishDecorator {

    public DoubleVenisonDecorator(Dish wrappee) {
        super(wrappee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Двойная порция оленины";
    }

    @Override
    public int getCost() {
        return super.getCost() + 20;
    }
}