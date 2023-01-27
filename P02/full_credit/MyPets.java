public class MyPets {
    public static void main(String[] args) {
        Pet petOne = new Pet("Sid", 10, Type.SLOTH);
        Pet petTwo = new Pet("Rufus", 5, Type.NAKED_MOLE_RAT);
        Pet petThree = new Pet("Dexter", 25, Type.CAPUCHIN_MONKEY);
        Pet petFour = new Pet("Odin", 32, Type.RAVEN);
        Pet petFive = new Pet("Swimmy", 3, Type.OTTER);

        var petArray = new Pet[]{petOne, petTwo, petThree, petFour, petFive};

        for (Pet pet : petArray) {
            System.out.println(pet);
        }
    }
}
