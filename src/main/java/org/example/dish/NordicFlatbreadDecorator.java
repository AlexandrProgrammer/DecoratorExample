package org.example.dish;

public class NordicFlatbreadDecorator extends DishDecorator {

    public NordicFlatbreadDecorator(Dish wrappee) {
        super(wrappee);
    }

    @Override
    public String getDescription() {
        return wrappee.getDescription() + " + Нордская лепёшка";
    }

    @Override
    public int getCost() {
        return wrappee.getCost() + 7;
    }
}