package 动态规划;

public class LCR156 {
    public int crackNumber(int ciphertext) {
        String s = String.valueOf(ciphertext);
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i=0 ; i<n ; i++) {
            dp[i+1] += dp[i];
            if (i >= 1 && s.charAt(i-1) != '0' && Integer.parseInt(s.substring(i-1, i+1)) < 26) {
                dp[i+1] += dp[i-1];
            }
        }
        return dp[n];
    }
}
