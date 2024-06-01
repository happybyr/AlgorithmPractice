package 动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution2809 {
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size();
        int s1 = 0, s2 = 0;
        int[][] nums = new int[n][2];
        for (int i=0 ; i<n ; i++) {
            nums[i][0] = nums1.get(i);
            nums[i][1] = nums2.get(i);
            s1 += nums[i][0];
            s2 += nums[i][1];
        }
        Arrays.sort(nums, Comparator.comparingInt(a -> a[1]));
        int[] dp = new int[n+1];
        for (int i=0 ; i<n ; i++) {
            int a = nums[i][0];
            int b = nums[i][1];
            for (int j=i+1 ; j > 0 ; j--) {
                dp[j] = Math.max(dp[j], dp[j-1] + a + j*b);
            }
        }

        for (int t = 0 ; t <= n ; t++) {
            if (s1 + t*s2 - dp[t] <= x) {
                return t;
            }
        }
        return -1;
    }

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            int i = 0;
            while (i < word.length()) {
                int j = i;
                while (j < word.length() && word.charAt(j) != separator) {
                    j++;
                }
                if (j-1 >= i) {
                    result.add(word.substring(i, j));
                }
                i = j+1;
            }
        }
        return result;
    }
}
