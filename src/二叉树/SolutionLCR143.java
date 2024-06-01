package 二叉树;

public class SolutionLCR143 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return isSubStructureWithRoot(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isSubStructureWithRoot(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }
        return isSubStructureWithRoot(a.left, b.left) && isSubStructureWithRoot(a.right, b.right);
    }
}
