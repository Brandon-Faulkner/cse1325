package store;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;
import java.util.regex.Pattern;

public class Customer implements Comparable<Customer>, Saveable{
    private String name;
    private String email;

    @Override
    public int compareTo(Customer c) {
        int result = name.compareTo(c.name);
        if(result == 0) { result = email.compareTo(c.email);}
        return result;
    }

    @Override
    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + '\n');
        bw.write(email + '\n');
    }
    
    public Customer (BufferedReader br) throws IOException {
        name = br.readLine();
        email = br.readLine();
    }

    public Customer(String name,String email){
        String regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        if (!Pattern.compile(regexPattern).matcher(email).matches()) {
            throw new IllegalArgumentException("The email provided for this customer was invalid.");
        }

        this.name = name;
        this.email = email;
    }

    @Override
    public String toString(){
        return name + " (" + email + ")";
    }

    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if(!(o instanceof Customer)) return false;
        Customer c = (Customer)o;
        return (name.equals(c.name)) && (email.equals(c.email));
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, email);
    }
    
}