package 滑动窗口;

public class Solution76 {
    public String minWindow(String s, String t) {
        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        int valid = 0;
        int[] window = new int[128];
        int minLen = Integer.MAX_VALUE;
        int start = -1;
        int left = 0, right = 0, n = s.length();
        while (right < n) {
            while (right < n && valid < t.length()) {
                int idx = s.charAt(right);
                if (need[idx] > window[idx]) {
                    valid++;
                }
                window[idx]++;
                right++;
            }
            while (valid >= t.length()) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                int idx = s.charAt(left);
                if (window[idx] <= need[idx]) {
                    valid--;
                }
                window[idx]--;
                left++;
            }
        }
        return start == -1 ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        new Solution76().minWindow("ADOBECODEBANC", "ABC");
    }
}
