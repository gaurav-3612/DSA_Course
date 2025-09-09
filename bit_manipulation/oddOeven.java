package bit_manipulation;

public class oddOeven{
    public static void exenOdd(int n){
        int bitmask=1;
        // n & bitmask it is wrong (n & bitmask) it is right
        if((n & bitmask)==0){
            System.out.println("even number");
        }
        else{
            System.out.println("odd number");
        }
    }
    public static void main(String args[]){
        exenOdd(5);
        exenOdd(10);
        exenOdd(0);
    }
}