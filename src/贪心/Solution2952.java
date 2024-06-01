package 贪心;

import java.util.Arrays;

public class Solution2952 {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int n = coins.length;
        int x = 1, ans = 0, i = 0;
        while (x <= target) {
            if (i < n && coins[i] <= x) {
                x = x + coins[i++];
            } else {
                ans++;
                x = 2*x;
            }
        }
        return ans;
    }
}
