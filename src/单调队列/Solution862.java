package 单调队列;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution862 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] preSum = new long[n+1];
        for (int i=0 ; i<n ; i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }
        int res = n+1;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=0 ; i<=n ; i++) {
            while (!deque.isEmpty() && preSum[deque.peekLast()] >= preSum[i]) {
                deque.pollLast();
            }
            while (!deque.isEmpty() && preSum[i] - preSum[deque.peekFirst()] >= k) {
                res = Math.min(res, i-deque.pollFirst());
            }
            deque.addLast(i);
        }
        return res == n+1 ? -1 : res;
    }
}
