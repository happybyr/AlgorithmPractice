package 回溯DFS相关;

import java.util.ArrayList;
import java.util.List;

public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, n, k, 1, new ArrayList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int n, int k, int start, List<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=start ; i <= n-(k-path.size())+1 ; i++) {
            path.add(i);
            dfs(res, n, k, i+1, path);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        new Solution77().combine(4, 2);
    }
}
