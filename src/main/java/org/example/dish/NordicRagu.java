package dish;

public class NordicRagu implements org.example.dish.Dish {

    @Override
    public String getDescription() {
        return "Нордское рагу";
    }

    @Override
    public int getCost() {
        return 50;
    }
}