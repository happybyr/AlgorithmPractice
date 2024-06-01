package 数位dp;

import java.util.Arrays;

public class Solution233 {
    int[][] dp;
    char[] arr;
    public int countDigitOne(int n) {
        arr = String.valueOf(n).toCharArray();
        dp = new int[arr.length][arr.length];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return f(0, 0, true);
    }

    private int f(int start, int sum, boolean isLimited) {
        if (start == arr.length) {
            return sum;
        }
        if (!isLimited && dp[start][sum] != -1) {
            return dp[start][sum];
        }
        int up = isLimited ? arr[start]-'0' : 9;
        int ans = 0;
        for (int i=0 ; i<=up ; i++) {
            ans += f(start + 1, i == 1 ? sum+1 : sum, isLimited && (i == up));
        }
        if (!isLimited) {
            dp[start][sum] = ans;
        }
        return ans;
    }
}
