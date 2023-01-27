public enum Type {
    SLOTH("sloth", 20), 
    NAKED_MOLE_RAT("naked mole rat", 30), 
    CAPUCHIN_MONKEY("capuchin monkey", 25), 
    RAVEN("raven", 10), 
    OTTER("otter",12);

    private final String animal;
    private final double lifespan;

    private Type(String animal, double lifespan) {
        this.animal = animal;
        this.lifespan = lifespan;
    }

    public double lifespan() {
        return lifespan;
    }

    @Override
    public String toString() {
        return animal;
    }
}
