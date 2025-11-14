import static org.junit.jupiter.api.Assertions.*;
/**
 * Unit tests for the Taco class.
 * Tests toppings, sauces, meat, cheese, and price calculations for various taco configurations.
 */

public class TacoTest {

    Taco taco;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        taco = new Taco(Taco.Shell.CORN, Taco.Size.SINGLE);
        taco.setMeat("Carne Asada");
        taco.setCheese("Cheddar");
        taco.setExtraMeat(true);
        taco.setExtraCheese(true);
        taco.setIsFried(false);
        taco.addToppings(1);
        taco.addToppings(3);
        taco.addSauce(2);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        taco = null;
    }

    @org.junit.jupiter.api.Test
    void addToppings() {
        assertEquals("Lettuce", taco.getToppings().get(0));
        assertEquals("Onions", taco.getToppings().get(1));
    }

    @org.junit.jupiter.api.Test
    void addSauce() {
        assertEquals("Salsa Roja", taco.getSauces().get(0));
    }

    @org.junit.jupiter.api.Test
    void getMeat() {
        assertEquals("Carne Asada", taco.getMeat());
    }

    @org.junit.jupiter.api.Test
    void getCheese() {
        assertEquals("Cheddar", taco.getCheese());
    }

    @org.junit.jupiter.api.Test
    void getPrice() {
        double price = 3.50 + 1.00 + 0.75 + 0.50 + 0.30;
        assertEquals(price, taco.getPrice());
    }

    @org.junit.jupiter.api.Test
    void getPrices() {
        Taco taco1 = new Taco(Taco.Shell.HARD_SHELL, Taco.Size.THREE_TACO);
        taco1.setMeat("Al Pastor");
        taco1.setCheese("Cotija");
        taco1.setExtraMeat(true);
        taco1.setExtraCheese(false);
        taco1.setIsFried(true);

        Taco taco2 = new Taco(Taco.Shell.FLOUR, Taco.Size.BURRITO);
        taco2.setMeat("Pollo");
        taco2.setCheese("Oaxaca");
        taco2.setExtraMeat(false);
        taco2.setExtraCheese(true);
        taco2.setIsFried(true);

        assertEquals(12.6, taco1.getPrice());
        assertEquals(14.65, taco2.getPrice());
    }

}