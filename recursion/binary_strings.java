package recursion;

public class binary_strings {

    public static void printStrings(int n, int lastplace, String str) {
        // base case
        if (n == 0) {
            System.out.println(str);
            return;
        }
        // kaam
        printStrings(n - 1, 0, str + "0");
        if (lastplace == 0) {
            printStrings(n - 1, 1, str + "1");
        }
    }

    public static void main(String[] args) {
        printStrings(3, 0, new String());
    }
}
