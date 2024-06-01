package 回溯DFS相关;

import java.util.ArrayList;
import java.util.List;

public class Solution386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i=1 ; i<=9 ; i++) {
            dfs(ans, n, i);
        }
        return ans;
    }

    private void dfs(List<Integer> ans, int n, int num) {
        if (num > n) {
            return;
        }
        ans.add(num);
        for (int i=0 ; i<=9 ; i++) {
            dfs(ans, n, num*10+i);
        }
    }

    public List<Integer> lexicalOrder2(int n) {
        List<Integer> ans = new ArrayList<>();
        int j = 1;
        for (int i=1 ; i<=n ; i++) {
            ans.add(j);
            if (j * 10 <= n) {
                j *= 10;
            } else {
               while (j % 10 == 9 || j + 1 > n) {
                   j /= 10;
               }
            }
        }
        return ans;
    }
}
