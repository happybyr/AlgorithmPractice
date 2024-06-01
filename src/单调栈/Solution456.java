package 单调栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution456 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int k = Integer.MIN_VALUE;
        for (int i=n-1 ; i>=0 ; i--) {
            if (nums[i] < k) {
                return true;
            }
            while (!stack.isEmpty() && stack.peekLast() < nums[i]) {
                k = Math.max(k, stack.pollLast());
            }
            stack.addLast(nums[i]);
        }
        return false;
    }

}
