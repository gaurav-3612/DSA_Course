package sortings;

public class insertion_sort {

    public static void insertion_sort(int array[]) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int curr = array[i];
            int prev = i - 1;
            while (prev >= 0 && array[prev] > curr) {
                array[prev + 1] = array[prev];
                prev--;

            }
            array[prev + 1] = curr;
        }
    }

    public static void main(String args[]) {
        int array[] = {5, 1, 4, 3, 2};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
        insertion_sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}
/*
 Insertion Sort Algorithm – Short Notes

Idea:

Sorts an array by building a sorted portion from left to right.

Like sorting playing cards in your hand.

Steps:

Start from the second element (i = 1).

Store the current element: curr = array[i].

Compare curr with elements in the sorted left part (array[0..i-1]).

Shift all larger elements one position right: array[prev + 1] = array[prev].

Insert curr in the correct position: array[prev + 1] = curr.

Repeat for all elements.

Key Points:

The left part is always sorted.

Shifting elements creates a “hole” for curr.

In-place sorting → no extra array needed.

Time Complexity:

Best: O(n) (already sorted)

Worst: O(n²) (reverse sorted)

Space Complexity: O(1)
 */
