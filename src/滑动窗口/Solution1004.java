package 滑动窗口;

public class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        int ans = 0, left = 0;
        int cnt0 = 0;
        for (int right=0 ; right<nums.length ; right++) {
            cnt0 += (1-nums[right]);
            while (cnt0 > k) {
                cnt0 -= (1-nums[left++]);
            }
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
}
