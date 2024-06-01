package 数位dp;

import java.util.Arrays;

public class Solution2376 {
    char[] arr;
    int[][] dp;
    public int countSpecialNumbers(int n) {
        arr = String.valueOf(n).toCharArray();
        int m = arr.length;
        dp = new int[m][1<<10];
        for (int i=0 ; i<m ; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, true, false);
    }

    // isNum : start前面填过数字了，可以从0开始，否则必需从1开始
    private int f(int start, int mask, boolean isLimited, boolean isNum) {
        if (start == arr.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimited && isNum && dp[start][mask] != -1) {
            return dp[start][mask];
        }
        int res = 0;
        if (!isNum) {
            res += f(start+1, mask, false, false);
        }
        int up = isLimited ? arr[start] - '0' : 9;
        for (int i = isNum ? 0 : 1 ; i <= up ; i++) {
            if ((mask >> i & 1) == 0) {
                res += f(start + 1, mask | (1 << i), isLimited && i == up, true);
            }
        }
        if (!isLimited && isNum) {
            dp[start][mask] = res;
        }
        return res;
    }
}
