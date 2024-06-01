package 动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution514 {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        List<Integer>[] record = new List[26];
        for (int i=0 ; i<26 ; i++) {
            record[i] = new ArrayList<>();
        }
        for (int i=0 ; i<n ; i++) {
            char c = ring.charAt(i);
            record[c-'a'].add(i);
        }
        int[][] dp = new int[m][n];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        for (int i=0 ; i<m ; i++) {
            for (int j : record[key.charAt(i)-'a']) {
                if (i == 0) {
                    dp[i][j] = Math.min(dp[i][j], calc(n, 0, j) + 1);
                    continue;
                }

                for (int k : record[key.charAt(i-1)-'a']) {
                    dp[i][j] = Math.min(dp[i-1][k] + calc(n, k, j) + 1, dp[i][j]);
                }
            }
        }
        return Arrays.stream(dp[m-1]).min().getAsInt();
    }

    private int calc(int n, int a, int b) {
        return Math.min((n+a-b)%n, (n+b-a)%n);
    }
}
