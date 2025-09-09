package pattern;

import java.util.Scanner;

public class pyramid {

    public static void pyramid(int height) {
        for (int i = 1; i <= height; i++) {
            // Print spaces
            for (int j = 1; j <= height - i; j++) {
                System.out.print(" ");
            }
            // Print stars
            // learn this formula 2*i-1
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        pyramid(height);
    }
}
