import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static Scanner console = new Scanner(System.in);

    private static ArrayList<Item> itemCart = new ArrayList<>();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            exit = logic();
        }
    }

    private static boolean logic() {
        homeScreen();
        System.out.print("       👉 Enter your choice: ");
        String choice = Integer.toString(console.nextInt());
        switch(choice){
            case "1":
                orderMenu();
                break;
            case "0":
                return true;
            default:
                System.out.println("Invalid option");
        }
        return false;
    }

    private static void orderMenu() {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║                 📝 ORDER SCREEN 📝          ");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║  1) Add Taco                                 ║");
        System.out.println("║  2) Add Drink                                ║");
        System.out.println("║  3) Add Chips & Salsa                        ║");
        System.out.println("║  4) Checkout                                 ║");
        System.out.println("║  0) Cancel Order (return to Home Screen)     ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.print("       👉 Enter your choice: ");
        String choice = Integer.toString(console.nextInt());
        switch(choice){
            case "1":
                tacoLogic();
            case "2":
                drinkLogic();

            default:
                System.out.println("Invalid input try again");

        }

    }

    private static void drinkLogic() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Select your drink size:");
            System.out.println(" 1) Small - $2.00");
            System.out.println(" 2) Medium - $2.50");
            System.out.println(" 3) Large - $3.00");
            int choice = console.nextInt();
            console.nextLine();
            String input = "";
            switch(choice){
                case 1:
                    input = "Small";
                    exit = true;
                    break;
                case 2:
                input = "Medium";
                    exit = true;
                break;

                case 3:
                input = "Large";
                    exit = true;
                break;
                default:
                    System.out.println("Invalid input. Try Again!");
                    orderMenu();
            }
            Drinks drink = new Drinks(input);
            itemCart.add(drink);
        }

    }

    private static void tacoLogic() {
        boolean exit = false;
        while (!exit) {
            try {
                shellMenu();
                Taco.Shell shell = null;
                int choice = console.nextInt();
                console.nextLine();
                switch (choice) {
                    case 1:
                        shell = Taco.Shell.CORN;
                        break;
                    case 2:
                        shell = Taco.Shell.FLOUR;
                        break;
                    case 3:
                        shell = Taco.Shell.HARD_SHELL;
                        break;
                    case 4:
                        shell = Taco.Shell.BOWL;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid shell choice!");
                }

                sizeMenu();
                Taco.Size size = null;
                choice = console.nextInt();
                console.nextLine();
                switch (choice) {
                    case 1:
                        size = Taco.Size.SINGLE;
                        break;
                    case 2:
                        size = Taco.Size.THREE_TACO;
                        break;
                    case 3:
                        size = Taco.Size.BURRITO;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid size choice!");
                }

                Taco taco = new Taco(shell, size);

                toppingsMenu();
                String[] temp = console.nextLine().split(",");
                for (String s : temp) {
                    taco.addToppings(Integer.parseInt(s));
                }

                saucesMenu();
                String[] temp2 = console.nextLine().split(",");
                for (String s : temp2) {
                    taco.addSauce(Integer.parseInt(s));
                }
                meatMenu();
                choice = console.nextInt();
                console.nextLine();
                switch(choice){
                    case 1:
                        taco.setMeat("Carne Asada");
                        break;
                    case 2:
                        taco.setMeat("Al Pastor");
                        break;
                    case 3:
                        taco.setMeat("Carnitas");
                        break;
                    case 4:
                        taco.setMeat("Pollo");
                        break;
                    case 5:
                        taco.setMeat("Chorizo");
                        break;
                    case 6:
                        taco.setMeat("Pescado");
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid meat choice!");
                }

                System.out.println("Extra meat? (Y for Yes / N for No):");
                String check = console.next();
                if(check.equalsIgnoreCase("Y")){
                    taco.setExtraMeat(true);
                }
                else if(check.equalsIgnoreCase("N")){
                    taco.setExtraMeat(false);
                }
                else{
                    throw new IllegalArgumentException("Invalid extra meat choice!");
                }
                System.out.println("Do you want it Fried? (Y for Yes / N for No):");
                check = console.next();
                if (check.equalsIgnoreCase("Y")) {
                    taco.setIsFried(true);
                } else if (check.equalsIgnoreCase("N")) {
                    taco.setIsFried(false);
                } else {
                    throw new IllegalArgumentException("Invalid fried choice!");
                }

                itemCart.add(taco);

            } catch (Exception e) {
                System.out.println("Invalid input! Please try again.");
                exit = true;
                orderMenu();
            }
        }
    }



    private static void meatMenu() {
        System.out.println("Select your meat (choose one):");
        System.out.println(" 1) Carne Asada");
        System.out.println(" 2) Al Pastor");
        System.out.println(" 3) Carnitas");
        System.out.println(" 4) Pollo");
        System.out.println(" 5) Chorizo");
        System.out.println(" 6) Pescado");

    }

    private static void saucesMenu() {
        System.out.println("Select your sauces (enter numbers separated by commas):");
        System.out.println(" 1) Salsa Verde");
        System.out.println(" 2) Salsa Roja");
        System.out.println(" 3) Chipotle");
        System.out.println(" 4) Habanero");
        System.out.println(" 5) Mild");
        System.out.println(" 6) Extra Hot");

    }

    private static void toppingsMenu() {
        System.out.println("Select your toppings (enter numbers separated by commas):");
        System.out.println(" 1) Lettuce");
        System.out.println(" 2) Cilantro");
        System.out.println(" 3) Onions");
        System.out.println(" 4) Tomatoes");
        System.out.println(" 5) Jalapeños");
        System.out.println(" 6) Radishes");
        System.out.println(" 7) Pico de Gallo");
        System.out.println(" 8) Guacamole");
        System.out.println(" 9) Corn");
    }

    private static void sizeMenu() {
        System.out.println("Select your taco size:");
        System.out.println("1) Single");
        System.out.println("2) 3-Taco");
        System.out.println("3) Burrito");
    }

    private static void shellMenu() {
        System.out.println("Select your shell:");
        System.out.println("1) Corn");
        System.out.println("2) Flour");
        System.out.println("3) Hard Shell");
        System.out.println("4) Bowl");

    }

    public static void homeScreen() {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║      🌮 WELCOME TO AHMED'S TACQUERIA 🌮       ");
        System.out.println("╚════════════════════════════════════════════════╝\n");

        System.out.println("       🌯 FRESH TACOS MADE YOUR WAY! 🌯\n");

        System.out.println("         [1] NEW ORDER");
        System.out.println("         [0] EXIT\n");

        System.out.println("       🔔 SELECT AN OPTION TO START 🔔\n");

    }
}
