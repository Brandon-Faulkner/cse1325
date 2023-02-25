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
        return name + " (" + (cost / 100) + ")";
    }

    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if(!(o instanceof Option)) return false;
        Option opt = (Option)o;
        return (name.equals(opt.name)) && (cost == opt.cost);
    }
}
