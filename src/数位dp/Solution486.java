package 数位dp;

public class Solution486 {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i=0 ; i<n ; i++) {
            dp[i][i] = nums[i];
        }
        // dp[i][j] = Math.max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1]);
        // i--;
        // j++;
        // j>i
        for (int i=n-2 ; i>=0 ; i--) {
            for (int j=i+1 ; j < n ; j++) {
                dp[i][j] = Math.max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1]);
            }
        }
        return dp[0][n-1] >= 0;
    }
}
