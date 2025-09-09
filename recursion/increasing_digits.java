package recursion;

public class increasing_digits {

    public static void IncDigits(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        IncDigits(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        IncDigits(50);
    }
}
