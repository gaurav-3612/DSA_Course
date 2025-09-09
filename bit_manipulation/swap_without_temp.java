package bit_manipulation;

public class swap_without_temp {

    public static void swap(int x, int y) {
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("after swap the value of x is " + x);
        System.out.println("after swap the value of y is " + y);
    }

    public static void main(String[] args) {
        int x = 3;
        int y = 4;
        System.out.println("before swap the value of x is " + x);
        System.out.println("before swap the value of y is " + y);
        swap(x, y);

        // here it wiil not change because of call by reference and value concept
        // System.out.println("after swap the value of x is " + x);
        // System.out.println("after swap the value of y is " + y);
    }

}
