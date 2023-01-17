import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("What is your name? : ");
        String nameInput = in.nextLine();
        System.out.println("Hello, " + nameInput);
        in.close();
    }
}
