package 单调队列;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=0 ; i<n ; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i-deque.peekFirst() >= k) {
                deque.pollFirst();
            }
            if (i >= k-1) {
                ans[i-k+1] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution239().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));
    }
}
