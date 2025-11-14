import java.util.HashMap;

public class Drinks extends Item {

    private final String size;
    final HashMap<String, Double> prices = new HashMap<String, Double>();
    Drinks(String size) {
        super("Drink");
        this.size = size;
        prices.put("Small", 2.00);
        prices.put("Medium", 2.50);
        prices.put("Large", 3.00);
    }

    @Override
    double getPrice() {
        return prices.get(size);
    }


}
