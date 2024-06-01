package 二叉树;

public class Solution110 {
    boolean b = true;
    public boolean isBalanced(TreeNode root) {
        getDepth(root);
        return b;
    }
    private int getDepth(TreeNode root) {
        if (root == null || !b) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left-right) > 1) {
            b = false;
            return 0;
        }
        return Math.max(left, right) + 1;
    }
}
