package dish;

public class SnowBerriesDecorator extends org.example.dish.DishDecorator {

    public SnowBerriesDecorator(org.example.dish.Dish wrappee) {
        super(wrappee);
    }

    @Override
    public String getDescription() {
        return super.Wrappee().getDescription() + " + Снежные ягоды";
    }

    @Override
    public int getCost() {
        return super.Wrappee().getCost() + 5;
    }
}