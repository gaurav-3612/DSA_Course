package Miscellaneous;
// leetcode 32

class FirstAndLastOcc {

    public int[] searchRange(int[] nums, int target) {
        int i = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                i = mid;
                break;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (i == -1) {
            return new int[]{-1, -1};
        }
        int p = i;
        int q = i;
        while (p >= 0 && nums[p] == target) {
            p--;
        }
        while (q < nums.length && nums[q] == target) {
            q++;
        }
        return new int[]{p + 1, q - 1};
    }
}
