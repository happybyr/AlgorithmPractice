package 单调栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution402 {
    public String removeKdigits(String num, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = num.length();
        for (int i=0 ; i<n ; i++) {
            int digit = num.charAt(i) - '0';
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > digit) {
                stack.pollLast();
                k--;
            }
            stack.addLast(digit);
        }
        while (k > 0) {
            stack.pollLast();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty() && stack.peek() == 0) {
            stack.pollFirst();
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
