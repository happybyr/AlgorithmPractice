package 动态规划;

import java.util.Arrays;

public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        k = Math.min(k, n / 2);
        int[] buy = new int[k+1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        int[] sell = new int[k+1];
        for (int price : prices) {
            for (int i=1 ; i<=k ; i++) {
                buy[i] = Math.max(buy[i], sell[i-1]-price);
                sell[i] = Math.max(sell[i], buy[i]+price);
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i=0 ; i<=k ; i++) {
            ans = Math.max(ans, sell[i]);
        }
        return ans;
    }
}
