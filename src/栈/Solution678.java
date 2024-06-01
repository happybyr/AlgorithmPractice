package 栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution678 {
    public boolean checkValidString(String s) {
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> star = new ArrayDeque<>();
        for (int i=0 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left.addLast(i);
            } else if (c == '*') {
                star.addLast(i);
            } else if (c == ')') {
                if (!left.isEmpty()) {
                    left.pollLast();
                } else if (!star.isEmpty()) {
                    star.pollLast();
                } else {
                    return false;
                }
            }
        }

        while (!left.isEmpty() && !star.isEmpty()) {
            if (left.pollLast() > star.pollLast()) {
                return false;
            }
        }
        return left.isEmpty();
    }
}
