package Code;
public class Comparation {
    public void comparator(int l1,int b1){
        if(l1==-1){
            System.out.println("Linear search result not found");
        }
        else if(b1==-1){
            System.out.println("Binary search result not found");
        }else{
            System.out.println("Linear Search count O(n)"+l1);
            System.out.println("Binary search count O(log n)"+b1);
        }
    }
}
