package store;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;

public class Store {
    public Store(String name) {
        this.name = name;
    }
    public String name() {
        return this.name;
    }

    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + '\n');

        //Customer
        bw.write("" + customers.size() + '\n');
        for (Customer customer : customers) customer.save(bw);

        //Options
        bw.write("" + options.size() + '\n');
        for (Option option : options) option.save(bw);

        //Computers
        bw.write("" + computers.size() + '\n');
        for (Computer computer: computers) computer.save(bw);

        //Orders
        //TODO Sprint 4
    }
    
    public Store (BufferedReader br) throws IOException {
        name = br.readLine();

        //Customers
        int custSize = Integer.parseInt(br.readLine());
        while(custSize-- > 0) {
            Customer cust = new Customer(br);
            customers.add(cust);
        }

        //Options
        int optSize = Integer.parseInt(br.readLine());
        while(optSize-- > 0) {
            Option opt = new Option(br);
            options.add(opt);
        }

        //Computers
        int compSize = Integer.parseInt(br.readLine());
        while(compSize-- > 0) {
            Computer comp = new Computer(br);
            computers.add(comp);
        }

        //Orders
        //TODO Sprint 4
    }
    
    // ///////////////////////////////////////////////////////////
    // Customers
    
    public void add(Customer customer) {
        if(!customers.contains(customer)) customers.add(customer);
    }
    public Object[] customers() {
        return this.customers.toArray();
    }
    
    // ///////////////////////////////////////////////////////////
    // Options
    
    public void add(Option option) {
        if(!options.contains(option)) options.add(option);
    }
    public Object[] options() {
        return this.options.toArray();
    }
    
    // ///////////////////////////////////////////////////////////
    // Computers
    
    public void add(Computer computer) {
        if(!computers.contains(computer)) computers.add(computer);
    }
    public Object[] computers() {
        return this.computers.toArray();
    }
    
    // ///////////////////////////////////////////////////////////
    // Orders
    
    public void add(Order order) {
        if(!orders.contains(order)) orders.add(order);
    }
    public Object[] orders() {
        return this.orders.toArray();
    }

    // ///////////////////////////////////////////////////////////
    // Fields
    
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Option> options = new ArrayList<>();
    private ArrayList<Computer> computers = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
}
