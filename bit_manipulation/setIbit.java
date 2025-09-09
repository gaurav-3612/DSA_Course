package bit_manipulation;

public class setIbit {
    // it means that we want to set 1 at position n of m binary number
    public static void bitSet(int m, int n){
        int bitmask=1<<n;
        System.out.println(m | bitmask);
    }
    public static void main (String args[]){
        bitSet(10,2);
    }
}
