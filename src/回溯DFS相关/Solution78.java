package 回溯DFS相关;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
        } else {
            dfs(nums, index + 1, path, res);
            path.add(nums[index]);
            dfs(nums, index + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new Solution78().subsets(nums));
    }
}
