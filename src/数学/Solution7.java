package 数学;

public class Solution7 {
    public int reverse(int x) {
        final int MAX_BOUND = Integer.MAX_VALUE / 10;
        final int MIN_BOUND = Integer.MIN_VALUE / 10;
        final int MAX_TAIL = Integer.MAX_VALUE % 10;
        final int MIN_TAIL = Integer.MIN_VALUE % 10;
        int res = 0;
        while (x != 0) {
            if (res > MAX_BOUND || (res == MAX_BOUND && x % 10 > MAX_TAIL)) {
                return 0;
            }
            if (res < MIN_BOUND || (res == MIN_BOUND && x % 10 < MIN_TAIL)) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }
}
