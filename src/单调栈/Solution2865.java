package 单调栈;

import java.util.List;
import java.util.Stack;

// 单调栈+前后缀分解
public class Solution2865 {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = maxHeights.get(i);
        }
        long[] suf = new long[n+1];
        long[] pre = new long[n+1];
        long sum = 0;
        Stack<Integer> stack = new Stack<>();

        stack.push(n);
        for (int i=n-1 ; i>=0 ; i--) {
            while (stack.size() > 1 && heights[stack.peek()] > heights[i]) {
                int t = stack.pop();
                sum -= (long)heights[t] * (stack.peek()-t);
            }
            sum += (long)heights[i] * (stack.peek()-i);
            stack.push(i);
            suf[i] = sum;
        }

        stack.clear();
        stack.push(-1);
        long ans = sum;
        sum = 0;
        for (int i=0 ; i<n ; i++) {
            while (stack.size() > 1 && heights[stack.peek()] > heights[i]) {
                int t = stack.pop();
                sum -= (long)heights[t] * (t-stack.peek());
            }
            sum += (long)heights[i] * (i-stack.peek());
            stack.push(i);
            pre[i] = sum;
            ans = Math.max(ans, pre[i] + suf[i+1]);
        }

        return ans;
    }

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int n = nums.size();
        int[] dp = new int[n];
        int ans = 0;
        for (int i=0 ; i<n ; i++) {
            dp[i] = (i & 1) == 1 ? dp[i >> 1] + 1 : dp[i >> 1];
            if (dp[i] == k) {
                ans += nums.get(i);
            }
        }
        return ans;
    }
}
