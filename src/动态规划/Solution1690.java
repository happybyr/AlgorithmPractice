package 动态规划;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution1690 {

    // 递归
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] s = new int[n+1];
        for (int i=1 ; i<=n ; i++) {
            s[i] = stones[i-1] + s[i-1];
        }
        int[][] mem = new int[n][n];
        return dfs(0, n-1, mem, s);
    }

    private int dfs(int left, int right, int[][] mem, int[] s) {
        if (left == right) {
            return 0;
        }
        if (mem[left][right] != 0) {
            return mem[left][right];
        }
        int ans1 = s[right+1] - s[left+1] - dfs(left+1, right, mem, s);
        int ans2 = s[right] - s[left] - dfs(left, right-1, mem, s);
        int ans = Math.max(ans2, ans1);
        mem[left][right] = ans;
        return ans;
    }

    // 迭代
    public int stoneGameVII2(int[] stones) {
        int n = stones.length;
        int[] s = new int[n+1];
        for (int i=1 ; i<=n ; i++) {
            s[i] = stones[i-1] + s[i-1];
        }
        int[][] dp = new int[n][n];
//        dp[i][j] = Math.max(s[j+1] - s[i+1] - dp[i+1][j], s[i] - s[j] - dp[i][j-1]);
        for (int i=n-2 ; i>=0 ; i--) {
            for (int j=i+1 ; j<n ; j++) {
                dp[i][j] = Math.max(s[j+1] - s[i+1] - dp[i+1][j], s[j] - s[i] - dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }
}
