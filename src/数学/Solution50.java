package 数学;

public class Solution50 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        long b = n;      // 防止n是最小整数时溢出
        if (b < 0) {
            b = -b;
            x = 1/x;
        }
        double res = 1;
        while (b != 0) {
            if ((b & 1) == 1) {
                res *= x;
                x *= x;
            } else {
                x *= x;
            }
            b >>= 1;
        }
        return res;
    }
}
