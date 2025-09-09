package Miscellaneous;
// LEETCODE---> 3

class SlidingWindow {

    public int lengthOfLongestSubstring(String s) {
        int[] lastseen = new int[128];
        for (int i = 0; i < lastseen.length; i++) {
            lastseen[i] = -1;
        }
        int start = 0;
        int maxLength = 0;   // fix here
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (lastseen[ch] >= start) {
                start = lastseen[ch] + 1;
            }
            lastseen[ch] = end;
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
