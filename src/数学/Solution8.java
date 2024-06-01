package 数学;

public class Solution8 {
    public int myAtoi(String s) {
        int n = s.length();
        int index = 0;
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }
        int sign = 1;
        if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        int res = 0;
        int bound = Integer.MAX_VALUE/10;
        for (; index < n ; index++) {
            char c = s.charAt(index);
            if (!isDigit(c)) {
                break;
            }
            if (res > bound || (res == bound && c > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + c - '0';
        }
        return sign * res;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
