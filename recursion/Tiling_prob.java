package recursion;

public class Tiling_prob {

    public static int ways(int n) {
        // base case
        if (n == 0 || n == 1) {
            return 1;
        }
        // vertical case
        int vertical = ways(n - 1);

        // horizental
        int horizental = ways(n - 2);

        // total ways
        int total = vertical + horizental;
        return total;
    }

    public static void main(String[] args) {
        System.out.println(ways(3));
        System.out.println(ways(4));
        System.out.println(ways(5));
    }
}
