
/**
 * Represents a Chips and Salsa item.
 * Extends Item and defines its name and price.
 */

public class ChipsSalsa extends Item{

    ChipsSalsa(){
        super("Chips and Salsa");
    }

    public double getPrice(){
        return 1.50;
    }
}
