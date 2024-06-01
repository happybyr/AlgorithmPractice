package 栈;

import netscape.security.UserTarget;

import java.util.Stack;

public class Solution224 {
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> nums = new Stack<>();
        Stack<Integer> signs = new Stack<>();
        int res = 0;
        int sign = 1;
        int num = 0;
        for (int i=0 ; i<n ; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c == '+' || c == '-') {
                res += num * sign;
                sign = c == '+' ? 1 : -1;
                num = 0;
            } else if (c == '(') {
                nums.push(res);
                signs.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += sign*num;
                res *= signs.pop();
                res += nums.pop();
                sign = 1;
                num = 0;
            } else if (c >= '0' && c <= '9') {
                num = num*10 + c - '0';
            }
        }
        return res + num * sign;
    }
}
