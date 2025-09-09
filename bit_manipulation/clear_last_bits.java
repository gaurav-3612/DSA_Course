package bit_manipulation;

public class clear_last_bits {

    public static void clear(int n, int m) {
        int bitmask = ((~0) << m);
        System.out.println(n & bitmask);
    }

    public static void main(String args[]) {
        clear(15, 2);
    }
}
