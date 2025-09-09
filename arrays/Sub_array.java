package arrays;

public class Sub_array {
    public static void subArray(int array[]) {
        for (int s = 0; s < array.length; s++) { // Start from 0 to include single-element subarrays
            for (int e = s; e < array.length; e++) { // Start from s
                for (int i = s; i <= e; i++) { // Compare i with e
                    System.out.print(array[i] + ",");
                }
                System.out.println(); // Print a newline after each subarray
            }
        }
    }

    public static void main(String[] args) {
        int array[] = { 2, 4, 6, 8, 10 };
        subArray(array);
    }
}
