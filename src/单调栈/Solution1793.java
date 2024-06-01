package 单调栈;

import java.util.Stack;

public class Solution1793 {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i=0 ; i<n ; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i=n-1 ; i>=0 ; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for (int i=0 ; i<n ; i++) {
            if (left[i] < k && right[i] > k) {
                ans = Math.max(ans, nums[i] * (right[i]-left[i]-1));
            }
        }
        return ans;
    }

    // 双指针解法
    public int maximumScore2(int[] nums, int k) {
        int n = nums.length;
        int left = k, right = k;
        int ans = nums[k], minH = nums[k];
        for (int i = 0 ; i < n-1 ; i++) {
            if (left == 0 || (right < n-1 && nums[right+1] >= nums[left-1])) {
                right++;
                minH = Math.min(minH, nums[right]);
            } else {
                left--;
                minH = Math.min(minH, nums[left]);
            }
            ans = Math.max(ans, minH * (right-left+1));
        }
        return ans;
    }
}
