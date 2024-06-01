package 滑动窗口;

public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int pre = 0, back = 0;
        int curSum = 0;
        int ans = Integer.MAX_VALUE;
        while (pre < n) {
            while (curSum < target && pre < n) {
                curSum += nums[pre];
                pre++;
            }
            while (curSum >= target && back < pre) {
                ans = Math.min(ans, pre - back);
                curSum -= nums[back];
                back++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int res = new Solution209().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(res);
    }
}
