package 栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = pushed.length;
        if (popped.length != n) {
            return false;
        }
        int popIndex = 0;
        for (int pushIndex = 0 ; pushIndex < n ; pushIndex++) {
            stack.addLast(pushed[pushIndex]);
            while (!stack.isEmpty() && popIndex < n && stack.peekLast() == popped[popIndex]) {
                popIndex++;
                stack.removeLast();
            }
        }
        return popIndex == n && stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean b = new Solution946().validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1});
        System.out.println(b);
    }
}
