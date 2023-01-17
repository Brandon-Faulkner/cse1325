public class Hello {
    public static void main(String[] args) {
        String currentUser = System.getProperty("user.name");
        System.out.println("Hello, " + currentUser + "!");
    }
}
