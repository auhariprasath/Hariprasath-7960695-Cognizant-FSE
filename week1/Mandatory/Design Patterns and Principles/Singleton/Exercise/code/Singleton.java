import java.util.*;
class Singleton{
    private static Singleton s;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(s==null){
            s = new Singleton();
        }else{
            System.out.println("Object already created");
        }
        return s;
    }

}
class Main{
    public static void main(String[] args){
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        
        System.out.println("HashCode of object 1: "+obj1.hashCode());
        System.out.println("HashCode of object 2: "+obj2.hashCode());

        System.out.println(obj1==obj2);
    }
}