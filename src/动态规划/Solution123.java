package 动态规划;

public class Solution123 {
    public int maxProfit(int[] prices) {
        int oneBuy = Integer.MIN_VALUE;
        int oneBuyOneSell = 0;
        int twoBuyOneSell = Integer.MIN_VALUE;
        int twoBuyTwoSell = 0;
        for (int price : prices) {
            oneBuy = Math.max(oneBuy, -price);
            oneBuyOneSell = Math.max(oneBuyOneSell, oneBuy + price);
            twoBuyOneSell = Math.max(twoBuyOneSell, oneBuyOneSell - price);
            twoBuyTwoSell = Math.max(twoBuyTwoSell, twoBuyOneSell + price);
        }
        return Math.max(oneBuyOneSell, twoBuyTwoSell);
    }
}
