package 中位数;

import java.util.PriorityQueue;

public class SolutionLCP24 {
    public int[] numsGame(int[] nums) {
        int n = nums.length;
        int mod = 1000000007;
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b)-> b - a);
        PriorityQueue<Integer> right = new PriorityQueue<>();
        long leftSum = 0, rightSum = 0;
        int[] ans = new int[n];
        for (int i=0 ; i<n ; i++) {
            int num = nums[i] - i;
            if (i % 2 == 0) {
                if (!left.isEmpty() && left.peek() > num) {
                    leftSum -= left.peek();
                    leftSum += num;
                    left.offer(num);
                    num = left.poll();
                }
                right.add(num);
                rightSum += num;
                ans[i] = (int)((rightSum - right.peek() - leftSum) % mod);
            } else {
                if (!right.isEmpty() && right.peek() < num) {
                    rightSum -= right.peek();
                    rightSum += num;
                    right.offer(num);
                    num = right.poll();
                }
                left.add(num);
                leftSum += num;
                ans[i] = (int)((rightSum - leftSum) % mod);
            }
        }
        return ans;
    }
}
