package 数学;

public class Solution43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] dp = new int[m+n];
        for (int i=m-1 ; i>=0 ; i--) {
            for (int j=n-1 ; j>=0 ; j--) {
                int x = num1.charAt(i)-'0';
                int y = num2.charAt(j)-'0';
                dp[i+j+1] += x*y;
            }
        }
        for (int i=m+n-1 ; i>0 ; i--) {
            dp[i-1] += (dp[i]/10);
            dp[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        int start = dp[0] == 0 ? 1 : 0;
        for (int i=start ; i<m+n ; i++) {
            sb.append(dp[i]);
        }
        return sb.toString();
    }
}
