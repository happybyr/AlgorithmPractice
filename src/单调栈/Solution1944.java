package 单调栈;

import java.util.Stack;

class Solution1944 {
  // 1944. 队列中可以看到的人数
  public int[] canSeePersonsCount(int[] heights) {
    int n = heights.length;
    int[] ans = new int[n];
    Stack<Integer> stack = new Stack<>();
    for (int i=n-1 ; i>= 0 ; i--) {
      while (!stack.isEmpty() && stack.peek() < heights[i]) {
        stack.pop();
        ans[i]++;
      }
      if (!stack.isEmpty()) {
        ans[i]++;
      }
      stack.push(heights[i]);
    }
    return ans;
  }
}