public class MyPets {
    public static void main(String[] args) {
        Pet petOne = new Pet("Sid", 10, Type.SLOTH);
        Pet petTwo = new Pet("Rufus", 5, Type.NAKED_MOLE_RAT);
        Pet petThree = new Pet("Dexter", 12, Type.CAPUCHIN_MONKEY);
        Pet petFour = new Pet("Odin", 4, Type.RAVEN);
        Pet petFive = new Pet("Swimmy", 7, Type.OTTER);

        var petArray = new Pet[]{petOne, petTwo, petThree, petFour, petFive};

        for (Pet pet : petArray) {
            System.out.println(pet);
        }
    }
}
