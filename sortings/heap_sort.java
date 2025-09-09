package sortings;

public class heap_sort {

    public static void HeapSort(int arr[]) {
        int n = arr.length;
        // first convert to max heap for sorting in ascending order
        for (int i = n / 2; i >= 0; i--) { // here i is the non leaf nodes and started from n/2 beacuse greater than that are leaf nodes means no left and right so no effect on doing heapify on them
            heapify(arr, i, n);
        }
        for (int i = n - 1; i >= 0; i--) {
            // swap largest with last and put last out of heap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i); // again hepify
        }
    }

    public static void heapify(int arr[], int x, int size) {
        int left = 2 * x + 1; // thse are the childs of parent
        int right = 2 * x + 2;
        int maxValueIndex = x; // initiallt we are assuming root is the max value

        if (left < size && arr[left] > arr[maxValueIndex]) { // do not use Math.max beacuse we need to restore the index not the value
            maxValueIndex = left;
        }
        if (right < size && arr[right] > arr[maxValueIndex]) {
            maxValueIndex = right;
        }
        if (maxValueIndex != x) { // we do until we get that root is the maximum value
            int temp = arr[maxValueIndex];
            arr[maxValueIndex] = arr[x];
            arr[x] = temp;
            heapify(arr, maxValueIndex, size); // here we do not write the base case because this condition is already inside a condition which will act as a base case
        }
    }

    public static void main(String args[]) {
        int arr[] = {1, 5, 2, 8, 3, 9, 5};
        HeapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
/*
 🌳 Why This Works

Build a max heap → largest always at root.

Swap root with last → put max in its final place.

Reduce heap size by 1 → ignore last element.

Heapify root → restore max heap.

Repeat until array sorted.

🔑 Complexity

Building heap: O(n)

Extract max (n times) × heapify (log n): O(n log n)

Total = O(n log n), in-place.
 */
