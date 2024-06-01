package 动态规划;

public class Solution474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len+1][m+1][n+1];
        for (int i=1 ; i<=len ; i++) {
            int[] count = getCnt(strs[i-1]);
            for (int j=0 ; j<=m ; j++) {
                for (int k=0 ; k<=n ; k++) {
                    dp[i][j][k] = dp[i-1][j][k];
                    if (count[0] <= j && count[1] <= k) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j-count[0]][k-count[1]]+1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }
    private int[] getCnt(String str) {
        int zero = 0, one = 0;
        for (char c : str.toCharArray()) {
            if (c == '0') {
                zero++;
            }
            if (c == '1') {
                one++;
            }
        }
        return new int[]{zero, one};
    }
}
