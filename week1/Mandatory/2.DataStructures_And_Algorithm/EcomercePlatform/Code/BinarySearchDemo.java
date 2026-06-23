package Code;
public class BinarySearchDemo {
    public int BinarySearch(Product[] p, long id){
        int n = p.length;
        int count = 0;
        int l = 0;
        int r = n-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            count++;
            if(p[mid].productId == id){
                System.out.println("Binary Search Product Found");
                return count;
            }else if(p[mid].productId > id){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        
        return -1;
    }
}
