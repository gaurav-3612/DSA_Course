package my_strings;

import java.util.Scanner;

public class substring {

    public static void sub(String str, int si, int ei) {
        // method1 by creating function
        for (int i = si; i < ei; i++) {
            System.out.print(str.charAt(i));
        }
        System.out.println();
        // method 2 by using inbuilt function
        System.out.print(str.substring(si, ei));
    }

    public static void main(String args[]) {
        String str = "hello what is going on";
        Scanner sc = new Scanner(System.in);
        int si = sc.nextInt();
        int ei = sc.nextInt();
        sub(str, si, ei);
    }
}
