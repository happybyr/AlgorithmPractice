package 回溯DFS相关;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution78_2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int start, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i=start ; i<nums.length ; i++) {
            path.add(nums[i]);
            dfs(nums, i+1, path, res);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new Solution78_2().subsets(nums));
    }

    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> record = new HashMap<>();
        for (int i=0 ; i<n ; i++) {
            record.put(arr[i], i);
        }

        int[][] dp = new int[n][n];
        int ans = 2;
        for (int i=1 ; i<n ; i++) {
            for (int j=0 ; j<i ; j++) {
                int remain = arr[i] - arr[j];
                int idx = record.getOrDefault(remain, -1);
                dp[i][j] = idx >= 0 && idx < j ? dp[j][idx]+1 : 2;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans == 2 ? 0 : ans;
    }
}
