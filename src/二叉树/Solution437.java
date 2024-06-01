package 二叉树;

public class Solution437 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return pathSum(root.left, targetSum) + pathSum(root.right, targetSum) + pathSumStart(root, targetSum);
    }

    private int pathSumStart(TreeNode root, long sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (sum == root.val) {
            res++;
        }
        return res + pathSumStart(root.left, sum - root.val) + pathSumStart(root.right, sum - root.val);
    }
}
