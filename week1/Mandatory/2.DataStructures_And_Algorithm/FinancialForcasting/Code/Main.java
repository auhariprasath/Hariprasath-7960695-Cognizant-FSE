import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Current Value: ");
        double currentValue = sc.nextDouble();

        System.out.println();
        System.out.print("Rate: ");
        double rate = sc.nextDouble();

        System.out.println();
        System.out.print("Years: ");
        int n = sc.nextInt();

        System.out.println(FinancialForecast.forecast(currentValue,rate,n));
    }
}
