package 单调栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] r = new int[n];
        int[] l = new int[n];
        Arrays.fill(r, n);
        Arrays.fill(l, -1);
        // 左边，第一个大于等于
        // 右边，第一个大于
        for (int i=0 ; i<n ; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] <= nums[i]) {
                int idx = stack.pollLast();
                r[idx] = i;
            }
            stack.addLast(i);
        }
        stack.clear();
        for (int i=n-1 ; i>=0 ; i--) {
            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i]) {
                int idx = stack.pollLast();
                l[idx] = i;
            }
            stack.addLast(i);
        }
        int ans = 0;
        for (int i=0 ; i<n ; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                ans += (i-l[i]) * (r[i]-i);
            }
        }
        return ans;
    }
}
