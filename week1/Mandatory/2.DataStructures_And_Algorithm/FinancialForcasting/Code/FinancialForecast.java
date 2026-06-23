public class FinancialForecast {
    public static double forecast(double currentValue, double rate,int n){
        if(n == 0){
            return currentValue;
        }

        // FV(n)=FV(n−1)×(1+r)
        return forecast(currentValue, rate, n-1) * (1+rate/100);
    }
}


