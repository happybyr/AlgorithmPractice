package 二叉树;

public class Solution114 {
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (pre != null) {
            pre.right = root;
        }
        pre = root;
        flatten(root.left);
        flatten(root.right);
    }
}
