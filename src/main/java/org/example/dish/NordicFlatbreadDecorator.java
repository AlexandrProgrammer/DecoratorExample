package dish;

public class NordicFlatbreadDecorator extends org.example.dish.DishDecorator {

    public NordicFlatbreadDecorator(org.example.dish.Dish wrappee) {
        super(wrappee);
    }

    @Override
    public String getDescription() {
        return super.Wrappee().getDescription() + " + Нордская лепёшка";
    }

    @Override
    public int getCost() {
        return super.Wrappee().getCost() + 7;
    }
}