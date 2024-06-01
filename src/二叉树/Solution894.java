package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class Solution894 {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n % 2 == 0) {
            return res;
        }
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        for (int l = 1, r = n-1-l ; r > 0 ; l += 2, r -= 2) {
            List<TreeNode> lChilds = allPossibleFBT(l);
            List<TreeNode> rChilds = allPossibleFBT(r);
            for (TreeNode left : lChilds) {
                for (TreeNode right : rChilds) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
