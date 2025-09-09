package sortings;

//here we use integer data type of defining array instead of int because collections import work for integr data type
import java.util.Arrays;
import java.util.Collections;

public class inbuilt_sort {

    public static void sort1(Integer arr[]) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    public static void sort2(Integer arr[]) {
        Arrays.sort(arr, 1, 4);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    public static void sort3(Integer arr[]) {
        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    public static void sort4(Integer arr[]) {
        Arrays.sort(arr, 1, 4, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    public static void main(String args[]) {
        Integer arr[] = {5, 3, 4, 1, 2};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
        sort1(arr);
        System.out.println();
        arr = new Integer[]{5, 3, 4, 1, 2};
        sort2(arr);
        System.out.println();
        arr = new Integer[]{5, 3, 4, 1, 2};
        sort3(arr);
        System.out.println();
        arr = new Integer[]{5, 3, 4, 1, 2};
        sort4(arr);
    }
}
