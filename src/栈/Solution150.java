package 栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        int a = 0;
        int b = 0;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    a = stack.removeLast();
                    b = stack.removeLast();
                    stack.addLast(b + a);
                    break;
                case "-":
                    a = stack.removeLast();
                    b = stack.removeLast();
                    stack.addLast(b-a);
                    break;
                case "*":
                    a = stack.removeLast();
                    b = stack.removeLast();
                    stack.addLast(b*a);
                    break;
                case "/":
                    a = stack.removeLast();
                    b = stack.removeLast();
                    stack.addLast(b/a);
                    break;
                default:
                    stack.addLast(Integer.parseInt(token));
                    break;
            }
        }
        return stack.removeLast();
    }
}
