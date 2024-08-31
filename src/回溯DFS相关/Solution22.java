package 回溯DFS相关;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, new StringBuilder());
        return res;
    }

    private void dfs(int n, int left, int right, StringBuilder cur) {
        if (cur.length() == 2*n) {
            res.add(cur.toString());
            return;
        }
        if (left < n) {
            cur.append('(');
            dfs(n, left+1, right, cur);
            cur.deleteCharAt(cur.length()-1);
        }
        if (right < left) {
            cur.append(')');
            dfs(n, left, right+1, cur);
            cur.deleteCharAt(cur.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution22().generateParenthesis(3));
    }
}
