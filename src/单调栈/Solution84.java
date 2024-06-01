package 单调栈;

import java.util.Stack;

// https://leetcode.cn/problems/0ynMMM/description/
class Solution84 {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        int[] newHeights = new int[heights.length+2];
        for(int i=0 ; i<heights.length ; i++){
            newHeights[i+1] = heights[i];
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(0);
        for(int i=1 ; i<newHeights.length ; i++){
            while(newHeights[i] < newHeights[stack.peek()]){
                int curHeight = newHeights[stack.pop()];
                int width = i-stack.peek()-1;
                max = Math.max(max, curHeight*width);
            }
            stack.push(i);
        }
        return max;
    }
}