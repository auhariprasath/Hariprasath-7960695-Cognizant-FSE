import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Food f = Waiter.waiterWork(s);
        f.preparing();
    }
}
