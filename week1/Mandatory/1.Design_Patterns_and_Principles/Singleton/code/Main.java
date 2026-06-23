import java.util.*;
class Logger{
    private static Logger s;

    private Logger(){

    }

    public static Logger getInstance(){
        if(s==null){
            s = new Logger();
        }else{
            System.out.println("Object already created");
        }
        return s;
    }

}
class Main{
    public static void main(String[] args){
        Logger obj1 = Logger.getInstance();
        Logger obj2 = Logger.getInstance();
        
        System.out.println("HashCode of object 1: "+obj1.hashCode());
        System.out.println("HashCode of object 2: "+obj2.hashCode());

        System.out.println(obj1==obj2);
    }
}