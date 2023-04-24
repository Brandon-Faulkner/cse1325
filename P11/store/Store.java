package store;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
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
        save(bw, customers);
        save(bw, options);
        save(bw, computers);
        save(bw, orders);
    }

    private <E extends Saveable> void save(BufferedWriter bw, Set<E> set) throws IOException{
        bw.write("" + set.size() + '\n');
        for (E e : set) { e.save(bw); }
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
        int ordSize = Integer.parseInt(br.readLine());
        while(ordSize-- > 0) {
            Order ord = new Order(br);
            orders.add(ord);
        }
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
    private TreeSet<Customer> customers = new TreeSet<>();
    private HashSet<Option> options = new HashSet<>();
    private HashSet<Computer> computers = new HashSet<>();
    private HashSet<Order> orders = new HashSet<>();
}
