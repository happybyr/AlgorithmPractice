package 其他;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise {
    int[] candidates;
    int target;
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        Arrays.sort(candidates);
        visited = new boolean[candidates.length];
        dfs(0, 0);
        return res;
    }

    private void dfs(int start, int cur) {
        if (cur == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        visited[start] = true;
        path.add(candidates[start]);
        cur += candidates[start];
        for (int i=start+1 ; i<candidates.length ; i++) {
            if (candidates[i] != candidates[i-1] || visited[i-1]) {
                dfs(i, cur);
            }
        }
        visited[start] = false;
        path.remove(path.size()-1);
        cur -= candidates[start];
    }
}
