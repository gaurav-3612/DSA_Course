package recursion;

public class Reverse_digits {

    public static void DecDigits(int n) {
        if (n == 1) {
            System.out.print(n);
            return;
        }
        System.out.print(n + " ");
        DecDigits(n - 1);
    }

    public static void main(String[] args) {
        DecDigits(100);
    }
}
