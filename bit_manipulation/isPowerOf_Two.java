package bit_manipulation;

public class isPowerOf_Two {

    public static boolean PowerCheck(int n) {
        // if a number n is of 2^x then the AND of n and n-1 is 0
        return ((n) & (n - 1)) == 0;
    }

    public static void main(String args[]) {
        System.out.println(PowerCheck(16));
        System.out.println(PowerCheck(18));

    }
}
