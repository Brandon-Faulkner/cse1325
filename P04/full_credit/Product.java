public abstract class Product {
    protected double cost;
    protected String name;

    public Product(String name, double cost) {
        if (cost < 0) { throw new RuntimeException("Cost cannot be negative!");}
        this.cost = cost;
        this.name = name;
    }

    public abstract double price();

    @Override
    public String toString(){
        return String.format("%-10s %-10s %20s", name, "($" + cost + ")", String.format("$%.2f", price()));
    }
}