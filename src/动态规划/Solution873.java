package 动态规划;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution873 {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> record = new HashMap<>();
        for (int i=0 ; i<n ; i++) {
            record.put(arr[i], i);
        }

        int[][] dp = new int[n][n];
        int ans = 2;
        for (int i=1 ; i<n ; i++) {
            for (int j=0 ; j<i ; j++) {
                int remain = arr[i] - arr[j];
                int idx = record.getOrDefault(remain, -1);
                dp[i][j] = idx >= 0 && idx < j ? dp[j][idx]+1 : 2;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans == 2 ? 0 : ans;
    }
}
