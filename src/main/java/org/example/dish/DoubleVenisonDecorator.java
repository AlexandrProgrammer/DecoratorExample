package dish;

public class DoubleVenisonDecorator extends org.example.dish.DishDecorator {

    public DoubleVenisonDecorator(org.example.dish.Dish wrappee) {
        super(wrappee);
    }

    @Override
    public String getDescription() {
        return super.Wrappee().getDescription() + " + Двойная порция оленины";
    }

    @Override
    public int getCost() {
        return super.Wrappee().getCost() + 20;
    }
}