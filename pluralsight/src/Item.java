
/**
 * Abstract base class for all items in the POS system.
 * Defines a name and requires subclasses to implement getPrice().
 */

public abstract class Item {

    private String name;


    protected Item(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract double getPrice();

    public String toString() {
        return getName() + " - $" + String.format("%.2f", getPrice());
    }

}
