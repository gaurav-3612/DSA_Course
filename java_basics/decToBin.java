package java_basics;

public class decToBin {

    public static void Change(int n) {
        int bitnum = 0;
        int pow = 0;
        while (n > 0) {
            int rem = (n % 2);
            bitnum = bitnum + rem * (int) Math.pow(10, pow);
            n = n / 2;
            pow++;
        }
        System.out.println(bitnum);
    }

    public static void main(String args[]) {
        Change(7);
    }
}
