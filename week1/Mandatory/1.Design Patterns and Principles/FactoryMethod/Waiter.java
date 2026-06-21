public class Waiter {
    public static Food waiterWork(String s){
        if(s.equals("Pizza")){
            return new Pizza();
        }else if(s.equals("Burger")){
            return new Burger();
        }else{
            return new FrenchFries();
        }
    }
}
