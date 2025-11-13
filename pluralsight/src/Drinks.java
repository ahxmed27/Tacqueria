import java.util.HashMap;

public abstract class Drinks extends Item {

    Drinks(String drink){
        super("Drink");
    }

    protected double getPrice(String size) {
        HashMap<String, Double> prices = new HashMap<String, Double>();
        prices.put("Small", 2.00);
        prices.put("Medium", 2.50);
        prices.put("Large", 3.00);
        return prices.get(size);
    }
}
