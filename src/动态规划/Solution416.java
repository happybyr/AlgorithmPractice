package 动态规划;

public class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum&1) == 1) {
            return false;
        }
        boolean[] dp = new boolean[sum/2+1];
        dp[0] = true;
        for (int num : nums) {
            for (int i=sum/2 ; i>=num ; i--) {
                dp[i] |= dp[i-num];
            }
        }
        return dp[sum/2];
    }
}
