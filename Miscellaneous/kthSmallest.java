package Miscellaneous;
// gfg

public class kthSmallest {
}
//     import java.util.Random;

// class Solution {
//     public static int kthSmallest(int[] arr, int k) {
//         return quickSelect(arr, 0, arr.length - 1, k - 1);
//     }
//     public static int quickSelect(int[] arr, int left, int right, int k) {
//         if (left == right) {
//             return arr[left];
//         }
//         int pivot = findPartition(arr, left, right);
//         if (pivot == k) {
//             return arr[pivot];
//         } else if (pivot > k) {
//             return quickSelect(arr, left, pivot - 1, k);
//         } else {
//             return quickSelect(arr, pivot + 1, right, k);
//         }
//     }
//     public static int findPartition(int[] arr, int left, int right) {
//         int pivotIndex = left + new Random().nextInt(right - left + 1);
//         swap(arr, pivotIndex, right);  // move pivot to end
//         int pivotValue = arr[right];
//         int storeIndex = left;
//         for (int i = left; i < right; i++) {
//             if (arr[i] < pivotValue) {
//                 swap(arr, i, storeIndex);
//                 storeIndex++;
//             }
//         }
//         swap(arr, storeIndex, right);  // move pivot to its final place
//         return storeIndex;
//     }
//     public static void swap(int[] arr, int i, int j) {
//         int temp = arr[i];
//         arr[i] = arr[j];
//         arr[j] = temp;
//     }
// }
// }
/*
 ⚡ The Big Idea

QuickSelect is like QuickSort but only cares about the side that contains the answer.

Pick a pivot.

Partition array so that:

Elements < pivot go left.

Pivot goes in its correct position.

Elements > pivot go right.

If pivot index == k-1 → answer found.

If pivot index > k-1 → recurse left.

If pivot index < k-1 → recurse right.

This way we don’t sort the whole array — just enough to find kth smallest.

✅ Example:

arr = [7, 10, 4, 3, 20, 15], k = 3
We want the 3rd smallest.

Step 1: QuickSelect (whole array)

Range = [0..5]

Pick pivot → suppose pivot = 7

Partitioning [7, 10, 4, 3, 20, 15] around 7:

Elements smaller than 7 → [4, 3]

Elements larger than 7 → [10, 20, 15]

Pivot 7 placed in correct spot → index = 2

New array (partitioned): [4, 3, 7, 10, 20, 15]

Step 2: Compare pivot index with k-1

We want k=3 smallest → index = k-1 = 2

Pivot ended up at index 2

✅ This is exactly what we wanted → return arr[2] = 7

🎯 Why does this work?

Partition puts pivot in the position it would be in a fully sorted array.

If pivot index matches k-1, then pivot is exactly the kth smallest.

If pivot index is bigger than k-1, the kth smallest must be in the left half.

If pivot index is smaller, kth smallest must be in the right half.

We keep shrinking the range until we land exactly on kth element.

✅ Dry Run Another Example

arr = [2, 3, 1, 20, 15], k = 4
We want 4th smallest → index 3.

Pick pivot = 2

Partition → [1, 2, 3, 20, 15], pivot index = 1

Compare with k-1=3
→ 1 < 3 → search right side [3,20,15]

Range = [2..4], pick pivot = 20

Partition [3, 20, 15] → [3, 15, 20], pivot index = 4

Compare with 3
→ 4 > 3 → search left side [3,15]

Range = [2..3], pick pivot = 3

Partition [3,15] → [3,15], pivot index = 2

Compare with 3
→ 2 < 3 → search right side [15]

Range = [3..3], only element = 15 → ✅ answer.

So, 4th smallest = 15.
 */
