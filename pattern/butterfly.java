package pattern;

public class butterfly {

    public static void butterfly(int n) {
        // here n is half height of the butterfly
        // first half
        for (int i = 1; i <= n; i++) {
            // starting stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // middle spaces, the mo. of spaces in the middle is 2*(n-i) and if
            //  n were the yotal height then it would be(n-2i)
            for (int j = 1; j <= (2 * (n - i)); j++) {
                System.out.print(" ");
            }
            // last stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
        // second half
        for (int i = n; i >= 1; i--) {
            // starting stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // middle spaces, the mo. of spaces in the middle is 2*(n-i) 
            // and if n were the yotal height then it would be(n-2i)
            for (int j = 1; j <= (2 * (n - i)); j++) {
                System.out.print(" ");
            }
            // last stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        butterfly(7);
    }
}
