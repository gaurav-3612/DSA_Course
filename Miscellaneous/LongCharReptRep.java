package Miscellaneous;
// LEETCODE-> 424

class LongCharReptRep {

    public int characterReplacement(String s, int k) {
        int[] count = new int[26]; // frequency of each character
        int left = 0, maxCount = 0, result = 0;

        for (int right = 0; right < s.length(); right++) {
            // update frequency
            count[s.charAt(right) - 'A']++;

            // update max frequency in the window
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            // check if window is valid
            while ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--; // shrink from left
                left++;
            }

            // update result
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
// (right - left + 1) - maxCount > k this is actually the main condition here it defines the window size which must be always (right - left + 1) - maxCount <= k
