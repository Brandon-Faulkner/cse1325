import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyPets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int petNumInput = -1;

        Pet petOne = new Pet("Sid", 10, Type.SLOTH);
        Pet petTwo = new Pet("Rufus", 5, Type.NAKED_MOLE_RAT);
        Pet petThree = new Pet("Dexter", 12, Type.CAPUCHIN_MONKEY);
        Pet petFour = new Pet("Odin", 4, Type.RAVEN);
        Pet petFive = new Pet("Swimmy", 7, Type.OTTER);

        //New method to have a dynamic array of pets that will increase automatically
        List<Pet> petArray = new ArrayList<Pet>();
        
        //When you enter a number, the five pets above will be added to the array that many times
        while (petNumInput != 0) {
            System.out.print("How many times would you like to add 5 pets to the array? (enter 0 to exit) ");
            if(in.hasNextInt()) {
                petNumInput = in.nextInt();
            }
            if (petNumInput != 0) {
                for (int i = 0; i < petNumInput; i++) {
                    petArray.add(petOne);
                    petArray.add(petTwo);
                    petArray.add(petThree);
                    petArray.add(petFour);
                    petArray.add(petFive);
                }
                System.out.println("\n-- Current Pet Array --");
                for (Pet pet : petArray) {
                    System.out.println(pet);
                }
                System.out.println("-- End of Pet Array --\n");
            }
        } 
        
        in.close();
    }
}
