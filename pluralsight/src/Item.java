public abstract class Item {

    private String name;


    Item(String name){
        this.name = name;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    abstract double getPrice();

}
