package 动态规划;

public class Solution5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLen = 0;
        for (int j=0 ; j<n ; j++) {
            for (int i=0 ; i<=j ; i++) {
                if (s.charAt(i) == s.charAt(j) && (j-i <= 1 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if (j-i+1 > maxLen) {
                        maxLen = j-i+1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start+maxLen);
    }
}
