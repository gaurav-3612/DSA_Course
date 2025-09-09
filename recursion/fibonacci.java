package recursion;

public class fibonacci {

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
    // its space complexity is O(n) and time complexity is O(2^n)

    public static void main(String[] args) {
        System.out.println(fib(5));
    }
}
