package 回溯DFS相关;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution40 {
    int target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        this.target = target;
        dfs(candidates, res, new ArrayList<>(), 0, 0);
        return res;
    }
    private void dfs(int[] candidates, List<List<Integer>> res, List<Integer> path, int cur, int start) {
        if (cur == target) {
            res.add(new ArrayList<>(path));
        }
        if (cur > target) {
            return;
        }
        for (int i=start ; i<candidates.length ; i++) {
            if (i == start || candidates[i] != candidates[i - 1]) {
                path.add(candidates[i]);
                dfs(candidates, res, path, cur + candidates[i], i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
