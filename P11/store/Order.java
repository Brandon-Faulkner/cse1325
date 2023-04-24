package store;
import java.util.ArrayList;
import java.util.Objects;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class Order implements Saveable {
    private static long nextOrderNumber = 0;
    private long orderNumber;

    private Customer customer;
    private ArrayList<Computer> computers = new ArrayList<Computer>();

    @Override
    public void save(BufferedWriter bw) throws IOException {
        bw.write("" + orderNumber + '\n');
        customer.save(bw);
        bw.write("" + computers.size() + '\n');
        for (Computer computer : computers) {computer.save(bw);}
    }

    public Order (BufferedReader br) throws IOException {
        orderNumber =Long.parseLong(br.readLine());
        customer = new Customer(br);
        int size = Integer.parseInt(br.readLine());
        while(size-- > 0) computers.add(new Computer(br));
    }

    public Order(Customer customer){
        this.orderNumber = nextOrderNumber++;
        this.customer = customer;
    }

    public void addComputer(Computer computer){
        computers.add(computer);
    }

    long cost() {
        long total = 0;
        for (Computer computer : computers) {
            total += computer.cost();
        }
        return total;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Order " + orderNumber + " for " + customer.toString());
        for (Computer computer : computers) {
            builder.append("\n\n" + computer.toString());
        }
        Double total = ((Long)cost()).doubleValue() / 100;
        builder.append("\n\nTOTAL: $" + String.format("%.2f", total));

        return builder.toString();
    }

    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if(!(o instanceof Order)) return false;
        Order ord = (Order)o;
        return (this.customer.equals(ord.customer)) && (this.computers.equals(ord.computers));
    }

    @Override
    public int hashCode(){
        return Objects.hash(orderNumber, customer, computers);
    }
}
