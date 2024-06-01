package 动态规划;

public class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        // 0 卖出 1 买入
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i=1 ; i<n ; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }
}
