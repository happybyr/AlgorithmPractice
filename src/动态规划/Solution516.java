package 动态规划;

public class Solution516 {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int j=0 ; j<len ; j++) {
            dp[j][j] = 1;
            for (int i=j-1 ; i>=0 ; i--) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = (j > i+1) ? dp[i+1][j-1]+2 : j-i+1;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution516().longestPalindromeSubseq("cbbd"));
    }
}
