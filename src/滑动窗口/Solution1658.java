package 滑动窗口;

public class Solution1658 {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int res = -1;
        int left = 0, right = 0;
        int curSum = 0;
        while (right < nums.length) {
            curSum += nums[right++];
            while (left < right && curSum > sum-x) {
                curSum -= nums[left++];
            }
            if (curSum == sum-x) {
                res = Math.max(res, right-left);
            }
        }
        return res == -1 ? -1 : nums.length-res;
    }
}
