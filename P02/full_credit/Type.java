public enum Type {
    SLOTH("sloth"), 
    NAKED_MOLE_RAT("naked mole rat"), 
    CAPUCHIN_MONKEY("capuchin monkey"), 
    RAVEN("raven"), 
    OTTER("otter");

    private final String animal;

    private Type(String animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return animal;
    }

    public double lifespan() {
        return 0;
    }
}
