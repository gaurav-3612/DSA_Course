package sortings;

public class quick_sort {

    public static void PrintArray(int arr[]) {
        System.out.println("before sorting");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
        System.out.println("after sorting");
        QuickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    public static void QuickSort(int arr[], int si, int ei) {
        // base case
        if (si >= ei) {
            return;
        }
        // kaam
        int pvt = Partition(arr, si, ei);
        QuickSort(arr, si, pvt - 1);
        // exclude the pivot element form quick sort
        //  recursive call because it is arlready at correct position
        QuickSort(arr, pvt + 1, ei);
    }

    public static int Partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;
        for (int j = si; j < ei; j++) { // here notice that we are not including ei 
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[ei];
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }
    // here our mission is to place all small elements than pivot plced at left and large elements at right side after
    // the place the pivot element at correct position then doing it recursively 

    public static void main(String[] args) {
        int arr[] = {6, 4, 3, 8, 5, 1};
        PrintArray(arr);
    }
}
/*
 📘 Quick Sort – Notes
Approach

Divide & Conquer algorithm.

Steps:

Pick a pivot element.

Partition: place pivot in its correct sorted position, so all smaller/equal elements are on the left and larger elements on the right.

Recursively apply Quick Sort on left and right subarrays.

Partition Function

Pivot = usually the last element (arr[ei]).

i = boundary of "≤ pivot" region (si-1 initially).

Traverse array with j:

If arr[j] <= pivot:

Increment i

Swap arr[i] and arr[j] (first type of swap)

→ builds the left region of smaller elements.

After loop:

Swap pivot with arr[i+1] (second swap)

→ pivot now sits at its final sorted position.

Return pivot index.

Why Two Swaps?

Inside loop swap → maintains partition:
arr[si...i] ≤ pivot, arr[i+1...j] > pivot.

Final swap → moves pivot between smaller and greater regions.

Array = [6, 4, 3, 8, 5, 1]

Pivot = 1 → [1, 4, 3, 8, 5, 6] (1 placed)

Pivot = 6 → [1, 4, 3, 5, 6, 8] (6 placed)

Pivot = 5 → [1, 4, 3, 5, 6, 8] (5 placed)

Pivot = 3 → [1, 3, 4, 5, 6, 8] (sorted)

 */
