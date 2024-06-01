package 数位dp;

import java.util.Arrays;

public class Solution2719 {
    private static final int MOD = 1_000_000_007;

    public int count(String num1, String num2, int min_sum, int max_sum) {
        int ans = calc(num2, min_sum, max_sum) - calc(num1, min_sum, max_sum) + MOD;
        int sum = 0;
        for (char c : num1.toCharArray()) {
            sum += (c - '0');
        }
        if (sum >= min_sum && sum <= max_sum) {
            ans += 1;
        }
        return ans % MOD;
    }

    private int calc(String num, int min_sum, int max_sum) {
        char[] arr = num.toCharArray();
        int m = num.length();
        int[][] dp = new int[m][Math.min(9*m, max_sum)+1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return dfs(0, 0, true, arr, dp, min_sum, max_sum);
    }

    private int dfs(int start, int sum, boolean isLimited, char[] arr, int[][] dp, int min_sum, int max_sum) {
        if (sum > max_sum) {
            return 0;
        }
        if (start == arr.length) {
            return sum >= min_sum ? 1 : 0;
        }
        if (!isLimited && dp[start][sum] != -1) {
            return dp[start][sum];
        }
        int up = isLimited ? arr[start] - '0' : 9;
        int ans = 0;
        for (int i=0 ; i<=up ; i++) {
            ans = (ans + dfs(start+1, sum + i, isLimited && (i == up), arr, dp, min_sum, max_sum)) % MOD;
        }
        if (!isLimited) {
            dp[start][sum] = ans;
        }
        return ans;
    }
}
