package store;

public class Option {
    protected String name;
    protected long cost;

    public Option(String name, long cost){
        if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be negative for a computer option.");
        }

        this.name = name;
        this.cost = cost;
    }

    public long cost() {return cost;}

    @Override
    public String toString() {
        Double dCost = ((Long)cost).doubleValue() / 100;
        return name + " ($" + String.format("%.2f", dCost) + ")";
    }

    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if(!(o instanceof Option)) return false;
        Option opt = (Option)o;
        return (name.equals(opt.name)) && (cost == opt.cost);
    }
}
