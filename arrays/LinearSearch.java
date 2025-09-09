package arrays;

import java.util.*;

public class LinearSearch {

    public static int LinearSearch(int numbers[], int key) {
        for (int i = 0; i < numbers.length; i++) {
            if (key == numbers[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int numbers[] = {4, 6, 6, 3, 9, 2, 0};
        System.out.println("enter the number you want to find");
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();

        int result = LinearSearch(numbers, key);
        if (result == -1) {
            System.out.println("number not found");
        } else {
            System.out.println("the number is at index " + result);
        }

    }

}
