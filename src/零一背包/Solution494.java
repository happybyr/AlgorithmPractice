package 零一背包;

public class Solution494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 != 0 || (sum + target) < 0) {
            return 0;
        }
        int t = (sum + target)/2;
        int[][] dp = new int[2][t+1];
        dp[0][0] = 1;
        int n = nums.length;
        for (int i=0 ; i<n ; i++) {
            for (int j=0 ; j<=t ; j++) {
                if (j < nums[i]) {
                    dp[(i+1)%2][j] = dp[i%2][j];
                } else {
                    dp[(i+1)%2][j] = dp[i%2][j] + dp[i%2][j-nums[i]];
                }
            }
        }
        return dp[n%2][t];
    }

    public int findTargetSumWays2(int[] nums, int target) {
        for (int num : nums) {
            target += num;
        }
        if (target < 0 || target % 2 == 1) {
            return 0;
        }
        target /= 2;
        int n = nums.length;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i=target ; i>=num ; i--) {
                dp[i] += dp[i-num];
            }
        }
        return dp[target];
    }
}
