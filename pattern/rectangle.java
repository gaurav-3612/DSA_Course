package pattern;

import java.util.Scanner;

public class rectangle {

    public static void rectangle(int length) {
        for (int i = 0; i < length; i++) {

            for (int j = 0; j < length - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        rectangle(length);
    }
}
