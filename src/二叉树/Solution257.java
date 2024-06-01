package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), root);
        return res;
    }

    private void dfs(List<String> res, List<Integer> path, TreeNode root) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            res.add(buildRes(path));
        }
        dfs(res, path, root.left);
        dfs(res, path, root.right);
        path.remove(path.size()-1);
    }

    private String buildRes(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<path.size() ; i++) {
            sb.append(path.get(i));
            if (i != path.size()-1) {
                sb.append("->");
            }
        }
        return sb.toString();
    }
}
