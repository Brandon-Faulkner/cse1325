public class Test {
    public static void main(String[] args) {
        //TEST #1: Verify a Taxfree product
        Taxfree testTaxfree = new Taxfree("Milk", 1.99);
        if (testTaxfree.name == null || testTaxfree.cost == 0) {
            System.err.println("FAIL: Taxfree not contructed properly - " + testTaxfree.name + ", " + testTaxfree.cost);
            System.exit(-1);
        }
        if (testTaxfree.toString() == null) {
            System.err.println("FAIL: toString not working with tax free");
            System.exit(-1);
        }

        //TEST #2: Verify a Taxed product no sales tax
        Taxed testTaxedOne = new Taxed("Donut",2.99);
        if (testTaxedOne.name == null || testTaxedOne.cost == 0) {
            System.err.println("FAIL: First taxed product not contructed properly - " + testTaxedOne.name + ", " + testTaxedOne.cost);
            System.exit(-1);
        }
        if (testTaxedOne.toString() == null) {
            System.err.println("FAIL: toString not working with first taxed product");
            System.exit(-1);
        }

        //TEST #3: Verify a Taxed product with sales tax
        Taxed testTaxedTwo = new Taxed("Poptart",3.99);
        Taxed.setTaxRate(0.0825);
        if (testTaxedTwo.name == null || testTaxedTwo.cost == 0) {
            System.err.println("FAIL: Second taxed product not contructed properly - " + testTaxedTwo.name + ", " + testTaxedTwo.cost);
            System.exit(-1);
        }
        if (testTaxedTwo.toString() == null) {
            System.err.println("FAIL: toString not working with second taxed product");
            System.exit(-1);
        }

        //TEST #4: Negative value for Taxfree
        try {
            Taxfree negTaxfree = new Taxfree("Milk", -1);
            System.err.println("FAIL: Taxfree negative not exception but " + negTaxfree.price());
            System.exit(-1);
        } catch (Exception e) {}

        //TEST #5: Negative value for Taxed
        try {
            Taxed negTaxed = new Taxed("Donut", -1);
            System.err.println("FAIL: Taxed negative not exception but " + negTaxed.price());
            System.exit(-1);
        } catch (Exception e) {}
    }
}
