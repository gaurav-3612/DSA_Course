package java_basics;

import java.util.*;

public class BinToDec {

    public static int BinToDec(int num) {
        int sum = 0;
        int i = 0;
        while (num > 0) {
            int rem = num % 10;
            sum = (int) (Math.pow(2, i)) * rem + sum;
            i = i + 1;
            num = num / 10;
        }
        return sum;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the binary number : ");
        int num = sc.nextInt();
        System.out.println("the decimal form of it is : " + BinToDec(num));

    }

}
