package 前后缀分解;


public class Solution42 {
    public int trap(int[] height) {
        int n = height.length;
        int pre[] = new int[n];
        pre[0] = height[0];
        for (int i = 1 ; i < n ; i++) {
            pre[i] = Math.max(height[i], pre[i - 1]);
        }

        int[] suf = new int[n];
        suf[n-1] = height[n-1];
        for (int i = n-2 ; i >=0 ; i--) {
            suf[i] = Math.max(suf[i+1], height[i]);
        }

        int ans = 0;
        for (int i = 0 ; i < n ; i++) {
            ans += Math.min(pre[i], suf[i]) - height[i];
        }
        return ans;
    }

    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        int suf = 0;
        for (int num : nums) {
            suf += num;
        }
        int pre = 0;
        int minDiff = Integer.MAX_VALUE, minIdx = 0;
        for (int i=0 ; i<n-1 ; i++) {
            pre += nums[i];
            suf -= nums[i];
            int diff = Math.abs(pre/(i+1)-suf/(n-i-1));
            if (diff < minDiff) {
                minDiff = diff;
                minIdx = i;
            }
        }
        if ((pre + nums[n-1])/n < minDiff) {
            return n-1;
        }
        return minIdx;
    }
}
