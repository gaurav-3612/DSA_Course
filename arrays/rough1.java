package arrays;

public class rough1 {

    public static void rough(int n) {
        if (n == 3) {
            return;
        }
        rough(n - 1);
        System.out.println("hello");
    }

    public static void main(String[] args) {
        rough(5);
    }
}
