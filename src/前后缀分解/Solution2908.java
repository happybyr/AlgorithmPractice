package 前后缀分解;

public class Solution2908 {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int[] suf = new int[n];
        suf[n-1] = nums[n-1];
        for (int i = n-2 ; i >= 0 ; i--) {
            suf[i] = Math.min(suf[i+1], nums[i]);
        }
        int pre = nums[0];
        int ans = Integer.MAX_VALUE;
        for (int i=1 ; i<n-1 ; i++) {
            if (nums[i] > pre && nums[i] > suf[i+1]) {
                ans = Math.min(ans, pre + nums[i] + suf[i+1]);
            }
            pre = Math.min(pre, nums[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
