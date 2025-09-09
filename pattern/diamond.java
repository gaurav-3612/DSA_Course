package pattern;

public class diamond {

    public static void diamond(int base) {
        // upper half we take base/2 for this
        for (int i = 1; i <= (base / 2); i++) {
            // for starting spaces which are base/2-i
            for (int j = 1; j <= (base / 2) - i; j++) {
                System.out.print(" ");
            }
            // for the stars in the middle and the are 2i-1
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            // here we do not need to print last spaces which are by default space
            System.out.println();
        }
        // for lower half
        for (int i = (base / 2); i >= 1; i--) {
            // for starting spaces which are base/2-i
            for (int j = 1; j <= (base / 2) - i; j++) {
                System.out.print(" ");
            }
            // for the stars in the middle and the are 2i-1
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        diamond(30);
    }
}
