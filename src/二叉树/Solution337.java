package 二叉树;


public class Solution337 {
    public int rob(TreeNode root) {
        int[] res = help(root);
        return Math.max(res[0], res[1]);
    }

    private int[] help(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = help(root.left);
        int[] right = help(root.right);
        int robRoot = root.val + left[1] + right[1];
        int notRobRoot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{robRoot, notRobRoot};
    }
}
