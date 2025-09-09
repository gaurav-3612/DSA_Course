package bit_manipulation;

public class count_set_bits {

    public static void countBits(int n) {
        int count = 0;
        int bitmask;
        while (n > 0) {
            bitmask = (1 & n);
            if (bitmask == 1) {
                count += 1;
            }
            // directly n>>1 written is wrong here
            n = n >> 1;
        }
        System.out.println(count);
    }

    public static void main(String args[]) {
        countBits(2);
        countBits(15);
        countBits(16);

    }
}
