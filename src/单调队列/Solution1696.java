package 单调队列;

import javafx.util.Pair;

import java.util.ArrayDeque;

public class Solution1696 {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        ArrayDeque<Pair<Integer, Integer>> deque = new ArrayDeque<>();
        int ans = nums[0];
        deque.addLast(new Pair<>(nums[0], 0));
        for (int i=1 ; i<n ; i++) {
            while (!deque.isEmpty() && i - deque.peekFirst().getValue() > k) {
                deque.pollFirst();
            }
            ans = deque.peekFirst().getKey() + nums[i];
            while (!deque.isEmpty() && deque.peekLast().getKey() <= ans) {
                deque.pollLast();
            }
            deque.offerLast(new Pair<>(ans, i));
        }
        return ans;
    }
}
