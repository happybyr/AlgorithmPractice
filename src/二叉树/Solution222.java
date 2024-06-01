package 二叉树;

import apple.laf.JRSUIUtils;

public class Solution222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        int left = levelCount(root.left);
        int right = levelCount(root.right);
        if(left == right) {
            ans = ans + (1 << left) + countNodes(root.right);
        } else {
            ans = ans + (1 << right) + countNodes(root.left);
        }
        return ans;
    }

    private int levelCount(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }
}
