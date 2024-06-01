package 回溯DFS相关;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, new ArrayList<>(), targetSum, 0);
        return res;
    }

    private void dfs(TreeNode root, List<List<Integer>> res, ArrayList<Integer> path, int targetSum, int cur) {
        if (root == null) {
            return;
        }
        cur += root.val;
        path.add(root.val);
        if (cur == targetSum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        if (root.left != null) {
            dfs(root.left, res, path, targetSum, cur);
        }
        if (root.right != null) {
            dfs(root.right, res, path, targetSum, cur);
        }
        cur -= root.val;
        path.remove(path.size()-1);
    }
}
