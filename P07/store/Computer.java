package store;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Computer {
    private String name;
    private String model;
    private ArrayList<Option> options = new ArrayList<Option>();

    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + '\n');
        bw.write(model + '\n');
        bw.write("" + options.size() + '\n');
        for (Option option : options) option.save(bw);
    }

    public Computer (BufferedReader br) throws IOException {
        name = br.readLine();
        model = br.readLine();
        int size = Integer.parseInt(br.readLine());
        while(size-- > 0) options.add(new Option(br));
    }

    public Computer(String name, String model){
        this.name = name;
        this.model = model;
    }
    
    public void addOption(Option option){
        options.add(option);
    }

    public long cost(){
        long sum = 0;

        for (Option option : options) {
            sum += option.cost();
        }

        return sum;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(name + " (" + model + ")");
        for (Option option : options) {
            builder.append("\n\t" + option.toString());
        }

        return builder.toString();
    }

    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if(!(o instanceof Computer)) return false;
        Computer c = (Computer)o;
        return (this.toString().equals(c.toString()));
    }
}
