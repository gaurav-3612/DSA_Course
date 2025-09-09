package arrays;

import java.util.Arrays;

public class ReturningArray {

    public static int[] createArray() {
        int[] newArr = {1, 2, 3, 4};
        return newArr;
    }

// OR
    public int[] getArray() {
        return new int[]{2, 4};  // use new int[]{ ... }
    }

    public static void main(String[] args) {
        System.out.print(Arrays.toString(createArray()));
    }
}
