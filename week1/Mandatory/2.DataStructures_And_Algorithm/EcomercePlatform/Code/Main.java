package Code;
public class Main {
    public static void main(String[] args) {

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mobile", "Electronics"),
                new Product(103, "Shoes", "Fashion"),
                new Product(104, "Watch", "Accessories"),
                new Product(105, "Laptop", "Electronics"),
                new Product(106, "Mobile", "Electronics"),
                new Product(107, "Shoes", "Fashion"),
                new Product(108, "Watch", "Accessories")
        };

        LinearSearchDemo l = new LinearSearchDemo();
        int l1 = l.LinearSearch(products, 108);
        BinarySearchDemo b = new BinarySearchDemo();
        int b1 = b.BinarySearch(products, 108);

        Comparation c = new Comparation();
        c.comparator(l1, b1);
    }
}