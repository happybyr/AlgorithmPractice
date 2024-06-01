package 单调栈;

import java.util.Stack;

//https://leetcode.cn/problems/maximal-rectangle/description/
public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int[] heights = new int[matrix[0].length+2];
        int maxArea = 0;
        for(int i=0 ; i<matrix.length ; i++){
            for(int j=0 ; j<matrix[0].length ; j++){
                if(matrix[i][j] == '1'){
                    heights[j+1] += 1;
                }else{
                    heights[j+1] = 0;
                }
            }
            maxArea = Math.max(maxArea, help(heights));
        }
        return maxArea;
    }

    private int help(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i=0 ; i<heights.length ; i++){
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int curHeight = heights[stack.pop()];
                int width = i-stack.peek()-1;
                max = Math.max(max, curHeight*width);
            }
            stack.push(i);
        }
        return max;
    }
}
