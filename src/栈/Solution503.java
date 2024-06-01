package 栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0 ; i<2*n ; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i%n]) {
                int idx = stack.pollLast();
                res[idx] = nums[i%n];
            }
            stack.addLast(i%n);
        }
        return res;
    }
}
