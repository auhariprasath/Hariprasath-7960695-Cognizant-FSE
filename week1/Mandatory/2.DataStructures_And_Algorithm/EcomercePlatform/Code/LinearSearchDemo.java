package Code;
public class LinearSearchDemo {
    public int LinearSearch(Product[] p, long id){
        int count = 0;
        for(Product i:p){
            count++;
            if(i.productId == id){
                System.out.println("LinearSearch Product Found");
                return count;
            }
        }
        
        
        return -1;
    }
}
