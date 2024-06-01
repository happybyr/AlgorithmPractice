package 动态规划;

public class Solution10 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i=2 ; i<=n ; i++) {
            if (p.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i-2];
            }
        }
        for (int i=1 ; i<=m ; i++) {
            for (int j=1 ; j<=n ; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    if (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') {
                        dp[i][j] = dp[i][j-1]      //匹配1个
                                    || dp[i][j-2]  //匹配0个
                                    || dp[i-1][j]; //匹配n个
                    } else {
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
