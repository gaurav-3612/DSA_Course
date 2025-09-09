package Miscellaneous;
// Pair Sum in a Sorted and Rotated Array--> gfg

class Solution {

    static boolean pairInSortedRotated(int[] arr, int target) {
        int n = arr.length;
        if (n < 2) {
            return false;
        }

        int l = findPivotWithDuplicates(arr);   // index of min
        int r = (l - 1 + n) % n;                // index of max

        while (l != r) {
            int sum = arr[l] + arr[r];
            if (sum == target) {
                return true;
            }
            if (sum < target) {
                l = (l + 1) % n;               // move forward circularly
            } else {
                r = (r - 1 + n) % n;           // move backward circularly
            }
        }
        return false;
    }

    // Works even when the array has duplicates
    static int findPivotWithDuplicates(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[end]) {
                start = mid + 1;
            } else if (arr[mid] < arr[end]) {
                end = mid;
            } else { // arr[mid] == arr[end]
                end--; // shrink safely when duplicates blur the boundary
            }
        }
        return start; // index of minimum element
    }
}

/*
  🔑 Key Idea

In a normal sorted array, we can use the two-pointer technique:

One pointer at the smallest element.

One pointer at the largest element.

Move pointers inward depending on sum.

In a rotated sorted array:

It’s still sorted, just wrapped around.

So first we find the pivot (index of the minimum element).

Then:

l = pivot (smallest element)

r = (pivot - 1 + n) % n (largest element, one step behind pivot in circular array)

Now simulate two-pointers in a circular fashion.
 */
