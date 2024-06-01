package 栈;

import java.util.Stack;

public class SolutionLCR946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        Stack<Integer> stack = new Stack<>();
        for(int pushIndex = 0 , popIndex = 0 ; pushIndex < len ; pushIndex++){
            stack.push(pushed[pushIndex]);
            while(!stack.isEmpty() && stack.peek() == popped[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
