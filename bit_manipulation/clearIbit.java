package bit_manipulation;

public class clearIbit {
    // it means we want 0 at mth place of n binary number
    public static void clearbit(int m,int n){
        int bitmask = ~(1<<n);
        System.out.println(m & bitmask);
    }
    public static void main (String args[]){
        clearbit(14,2);
    }
}
