package arrays;

public class kadanes {

    public static void kadanes(int array[]) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        for (int i = 0; i < array.length; i++) {
            cs = cs + array[i];
            ms = Math.max(cs, ms);
            if (cs < 0) {   // cs will be set to zero only if less than zero ex 100,-1,200 then ms is 299 not 300 because cs<0 by adding -1
                cs = 0;
            }
        }
        System.out.println("max subarray sum is : " + ms);

    }

    public static void main(String[] args) {
        int array[] = {-2, -3, 4, -1, -2, 1 - 5, -3};
        kadanes(array);
    }

}
/*
 | Index | Value | cs (current sum) | ms (max sum) |
| ----- | ----- | ---------------- | ------------ |
| 0     | -2    | -2 → reset to 0  | -2           |
| 1     | -3    | -3 → reset to 0  | -2           |
| 2     | 4     | 4                | 4 ✅          |
| 3     | -1    | 3                | 4            |
| 4     | -2    | 1                | 4            |
| 5     | -4    | -3 → reset to 0  | 4            |
| 6     | -3    | -3 → reset to 0  | 4            |

📌 Summary
🧠 What is the Question?
Given an integer array, find the maximum sum of any contiguous subarray — this is known as Kadane’s Algorithm.

⚙️ What does the code do?
It uses Kadane’s Algorithm to calculate the max subarray sum.

It runs in O(n) time — very efficient.

It prints the final result.
 */
