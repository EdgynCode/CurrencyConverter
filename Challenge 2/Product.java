public class Product {
    private String name;
    private double price;
    private int quantity;

    // Constructors
    public Product() {
        this.name = "";
        this.price = 0.0;
        this.quantity = 0;
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Utils
    public void printDetail() {
        System.out.println(this.name + ": price " + this.price + ", quantity " + this.quantity);
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
