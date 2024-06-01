package 二叉树;

public class Solution1026 {
    int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return ans;
    }

    private void dfs(TreeNode root, int mx, int mn) {
        if (root == null) {
            ans = Math.max(ans, mx - mn);
            return;
        }
        mx = Math.max(mx, root.val);
        mn = Math.min(mn, root.val);
        dfs(root.left, mx, mn);
        dfs(root.right, mx, mn);
    }
}
