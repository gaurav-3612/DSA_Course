package sortings;

public class selection_sort {

    public static void selection_sort(int array[]) {
        int n = array.length;
        int t;
        for (int i = 0; i < n - 1; i++) {
            int minpos = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minpos]) {
                    minpos = j;
                }
            }
            t = array[i];
            array[i] = array[minpos];
            array[minpos] = t;
        }
    }

    public static void main(String args[]) {
        int array[] = {5, 1, 4, 3, 2};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
        selection_sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}

/*
 Approach of Selection Sort

The Selection Sort algorithm works by repeatedly selecting the smallest element (in case of ascending order) from the unsorted part of the array and placing it at the correct position in the sorted part.

Steps:

Start with the first element (index i=0).

Find the minimum element from the remaining unsorted part (from i to end).

Swap this minimum element with the element at index i.

Now, the first element is in its correct position (sorted).

Move to the next index (i=1) and repeat until the whole array is sorted.

So the array is divided into:

Sorted part (on the left).

Unsorted part (on the right).
 */
