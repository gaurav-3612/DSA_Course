package Miscellaneous;
// leetcode --->81

class SearchRotatedWithDup {

    public boolean search(int[] nums, int target) {
        int si = 0, ei = nums.length - 1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // Handle duplicates
            if (nums[si] == nums[mid] && nums[mid] == nums[ei]) {
                si++;
                ei--;
            } // Left half sorted
            else if (nums[si] <= nums[mid]) {
                if (target >= nums[si] && target < nums[mid]) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            } // Right half sorted
            else {
                if (target > nums[mid] && target <= nums[ei]) {
                    si = mid + 1;
                } else {
                    ei = mid - 1;
                }
            }
        }
        return false;
    }
}
