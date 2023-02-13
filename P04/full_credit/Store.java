import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    private static ArrayList<Product> products = new ArrayList<Product>();
    private static ArrayList<Product> shoppingCart = new ArrayList<Product>();;

    public static void main(String[] args) {
        Taxed.setTaxRate(0.0825);
        products.add(new Taxfree("Milk", 2.99));
        products.add(new Taxfree("Eggs", 0.99));
        products.add(new Taxfree("Cheese", 1.99));

        products.add(new Taxed("Donuts", 4.99));
        products.add(new Taxed("Poptarts", 3.99));
        products.add(new Taxed("Ice Cream", 5.99));

        Scanner in = new Scanner(System.in);
        int userChoice = 0;
        double totalPrice = 0.0;

        try {
            while (userChoice != -1) {
                System.out.println("========================");
                System.out.println("  Welcome to the Store  ");
                System.out.println("========================\n");
                
                int productIndex = 0;
                for (Product product : products) {
                    System.out.println(productIndex + ") " + product.toString());
                    productIndex++;
                }

                System.out.println("\nCurrent Order");
                System.out.println("-------------\n");

                totalPrice = 0;
                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                    totalPrice += product.price();
                }

                System.out.printf("Total Price: $%.2f\n", totalPrice);
                System.out.print("Buy which product? ");

                if (in.hasNextInt()) {
                    userChoice = in.nextInt();                      
                    if (userChoice >= 0) {
                        if (userChoice > products.size() - 1) {
                            throw new RuntimeException("The number entered is not one of the listed available products.");
                        }
                        else{
                            shoppingCart.add(products.get(userChoice));
                        }                   
                    }
                } else {
                    throw new RuntimeException("The data entered was not a number. You must enter a number that matches the list of products.");
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }  
    }
}
