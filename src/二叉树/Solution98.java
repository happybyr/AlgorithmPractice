package 二叉树;

public class Solution98 {
    long cur = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= cur) {
            return false;
        }
        cur = root.val;
        return isValidBST(root.right);
    }
}
