package arrays;

public class sorted_matrix_search {

    public static boolean search(int matrix[][], int key) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (key == matrix[row][col]) {
                System.out.print("element found at (" + row + "," + col + ")");
                return true;
            } else if (key < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        System.out.print("element not found");
        return false;
    }

    public static void main(String args[]) {
        // The first integer of each row is greater than the last integer of the previous row.
        int matrix[][] = {{10, 20, 30, 40},
        {15, 25, 35, 45},
        {27, 29, 37, 48},
        {32, 33, 39, 50}};
        search(matrix, 33);
    }
}
// THE BINARY SEARCH IS ALSO USED FOR SEARCH OF MINIMUM ELEMENT IN A ROTATED ARRAY EXACTLY SAME CODE NO CHANGE
/*
 class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if(nums[mid] < nums[end]) {
                end = mid;
            }else{
                end--;
            }
        }

        return nums[start];
    }
}

 */
