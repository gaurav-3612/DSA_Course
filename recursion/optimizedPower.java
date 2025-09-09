package recursion;

public class optimizedPower {

    public static int optimized(int x, int n) {
        if (n == 0) {
            return 1;
        }
        // int halfPowerSq=optimized(x,n/2)*optimized(x, n/2);
        // we do not perform this because it will give O(n) time complexity
        // we do by another method to get O(logn) time complexity

        int halfpower = optimized(x, n / 2);
        int halfpowersq = halfpower * halfpower;
        int result = halfpowersq;
        if (n % 2 == 0) {
            return result;
        } else {
            return x * result;
        }
    }

    public static void main(String[] args) {
        System.out.println(optimized(2, 5));
        System.out.println(optimized(2, 10));
    }
}
