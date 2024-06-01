package 回溯DFS相关;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        boolean[] visited = new boolean[n];
        Arrays.sort(nums);
        dfs(res, nums, visited, new ArrayList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, boolean[] visited, List<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=0 ; i<nums.length ; i++) {
            if (visited[i]) {
                continue;
            }
            if (i == 0 || nums[i] != nums[i-1] || visited[i-1]) {
                path.add(nums[i]);
                visited[i] = true;
                dfs(res, nums, visited, path);
                visited[i] = false;
                path.remove(path.size()-1);
            }
        }
    }

}
