package store;
import java.util.ArrayList;

public class Order {
    private static long nextOrderNumber = 0;
    private long orderNumber;

    private Customer customer;
    private ArrayList<Computer> computers = new ArrayList<Computer>();

    public Order(Customer customer){
        this.orderNumber = nextOrderNumber++;
        this.customer = customer;
    }

    public void addComputer(Computer computer){
        computers.add(computer);
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Order " + orderNumber + " for " + customer.toString());
        for (Computer computer : computers) {
            builder.append("\n\n" + computer.toString());
        }

        return builder.toString();
    }

    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if(!(o instanceof Order)) return false;
        Order ord = (Order)o;
        return (this.customer.equals(ord.customer)) && (this.computers.equals(ord.computers));
    }
}
