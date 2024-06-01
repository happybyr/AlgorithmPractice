package 动态规划;

import java.util.HashSet;
import java.util.Set;

public class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Set<Integer> set = new HashSet<>();
        for (int i=0 ; i<n ; i++) {
            dp[i+1] = dp[i] + nums[i];
        }
        for (int i=2 ; i<=n ; i++) {
            set.add(dp[i-2]%k);
            if (set.contains(dp[i]%k)) {
                return true;
            }
        }
        return false;
    }
}
