import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Taco extends Item {

    public enum Shell {
        CORN,
        FLOUR,
        HARD_SHELL,
        BOWL
    }

    public enum Size {
        SINGLE,
        THREE_TACO,
        BURRITO
    }


    private Shell shell;

    private Size size;

    private String meat;

    private final HashMap<Integer, String> listOfToppings = new HashMap<>();

    private final HashMap<Integer, String> listOfSauces = new HashMap<>();

    private final ArrayList<String> toppings = new ArrayList<>();

    private final ArrayList<String> sauces = new ArrayList<>();

    private boolean extraMeat;

    private boolean isFried;

    Taco(Shell shell, Size size){
        super("Taco");
        this.shell = shell;
        this.size = size;
        isFried = false;
        extraMeat = false;
        initializeMenu();
    }

    public void addToppings(int x){
        toppings.add(listOfToppings.get(x));
    }

    public void addSauce(int x){
        sauces.add(listOfSauces.get(x));
    }
    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public boolean isExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }
    private void initializeMenu() {
        listOfToppings.put(1, "Lettuce");
        listOfToppings.put(2, "Cilantro");
        listOfToppings.put(3, "Onions");
        listOfToppings.put(4, "Tomatoes");
        listOfToppings.put(5, "Jalapeños");
        listOfToppings.put(6, "Radishes");
        listOfToppings.put(7, "Pico de Gallo");
        listOfToppings.put(8, "Guacamole");
        listOfToppings.put(9, "Corn");

        listOfSauces.put(1, "Salsa Verde");
        listOfSauces.put(2, "Salsa Roja");
        listOfSauces.put(3, "Chipotle");
        listOfSauces.put(4, "Habanero");
        listOfSauces.put(5, "Mild");
        listOfSauces.put(6, "Extra Hot");
    }
    public void setIsFried(boolean x) {
        isFried = x;
    }

    public void setFried(boolean fried) {
        isFried = fried;

        }


    public String toString(){
        StringBuilder reciept = new StringBuilder();
        reciept.append("=== Taco Details ===\n");
        reciept.append("Shell: " + shell + "\n");
        reciept.append("Size: " + size + "\n");
        reciept.append("Meat: " + meat + "\n");
        if(extraMeat){
            reciept.append("Extra Meat Ordered! \n");
        }
        reciept.append("Fried: ").append(isFried ? "Yes + \n" : "No + \n");

        reciept.append("Toppings: ");
        if (toppings.isEmpty()) {
            reciept.append("None");
        } else {
            reciept.append(String.join(", ", toppings));
        }
        reciept.append("\n");

        reciept.append("Sauces: ");
        if (sauces.isEmpty()) {
            reciept.append("None");
        } else {
            reciept.append(String.join(", ", sauces));
        }
        reciept.append("\n");

        return reciept.toString();
    }

    protected double getPrice(){
        return 0.00;
    }
}
