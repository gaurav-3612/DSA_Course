package recursion;

public class Rotated_array_search {

    public static int Search(int arr[], int target, int si, int ei) {
        // base case
        if (si > ei) {
            return -1;
        }
        // kaam
        int mid = si + (ei - si) / 2;
        // case found
        if (target == arr[mid]) {
            return mid;
        }
        // mid on line 1
        if (arr[si] <= arr[mid]) {
            // case a
            if (target >= arr[si] && target <= arr[mid]) {
                // since the function is of int return type so we have to return the recursive call
                return Search(arr, target, si, mid - 1);
            } // case b 
            else {
                return Search(arr, target, mid + 1, ei);
            }
        } // mid on line 2
        else {
            // case a
            if (target <= arr[ei] && target >= arr[mid]) {
                return Search(arr, target, mid + 1, ei);
            } // case b
            else {
                return Search(arr, target, si, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int targetIndx = Search(arr, target, 0, arr.length - 1);
        System.out.println(targetIndx);
    }
}
/*
TRUST

 arr = {10, 15, 16, 17, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
target = 0
si = 0, ei = 13

✅ Approach 1: Standard “sorted-half” check

Step 1:

mid = (0+13)/2 = 6 → arr[6] = 2

arr[0]=10 > arr[6]=2 → right half is sorted.

Check if target in [2..9]? → 0 not in range.

→ Search left: si=0, ei=5

Step 2:

mid = (0+5)/2 = 2 → arr[2] = 16

arr[0]=10 ≤ arr[2]=16 → left half is sorted.

Target in [10..16]? → 0 not in range.

→ Search right: si=3, ei=5

Step 3:

mid = (3+5)/2 = 4 → arr[4]=0

Target found ✅ index=4

✅ Approach 2: Your “direct range check”

At each step, check if target is in [si..mid-1] or [mid+1..ei].

Step 1:

mid = 6 → arr[6] = 2

Left range = arr[0]=10 … arr[5]=1 (not sorted, but we still check ranges)

Is 0 between 10 and 1? ❌

Right range = arr[7]=3 … arr[13]=9

Is 0 between 3 and 9? ❌

Uh oh… no half says “yes”. But target is actually in this array! ⚠️
 */
 /*

 -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 
  What happens if we drop target >= arr[si] and only do:
if (target <= arr[mid])


👉 Let’s test it.

Case 1: Works fine
arr = {10, 15, 16, 17, 0, 1, 2}
target = 15


si=0, ei=6, mid=3 → arr[mid]=17

Left is sorted.

target <= 17 → true.

We go left and find 15. ✅

Case 2: Breaks
arr = {10, 15, 16, 17, 0, 1, 2}
target = 1


si=0, ei=6, mid=3 → arr[mid]=17

Left is sorted.

If we only check target <= arr[mid], then 1 <= 17 is true.

We wrongly go left into {10,15,16}, where 1 does not exist. ❌
 */

// this can also be done by finding pivot by binary search as pivot is the smallest element of the array and then again use binary search for target search

