package dish;

public class FireSauceDecorator extends org.example.dish.DishDecorator {

    public FireSauceDecorator(org.example.dish.Dish wrappee) {
        super(wrappee);
    }

    @Override
    public String getDescription() {
        return super.Wrappee().getDescription() + " + Огненный соус";
    }

    @Override
    public int getCost() {
        return super.Wrappee().getCost() + 10;
    }
}