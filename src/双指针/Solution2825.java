package 双指针;

import java.util.HashMap;
import java.util.Map;

public class Solution2825 {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        int p1 = 0, p2 = 0;
        while (p1 < n1 && p2 < n2) {
            char c2 = str2.charAt(p2);
            while (p1 < n1) {
                char c1 = str1.charAt(p1++);
                char c11 = (char)((c1 + 1 - 'a')%26 + 'a');
                if (c1 == c2 || c11 == c2) {
                    p2++;
                    break;
                }
            }
        }
        return p2 >= n2;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0 ; i<n ; i++) {
            map.put(postorder[i], i);
        }
        return dfs(map, preorder, postorder, 0, n-1, 0, n-1);
    }

    private TreeNode dfs(Map<Integer, Integer> record, int[] preorder, int[] postorder, int preStart, int preEnd, int postStart, int postEnd) {
        if (preEnd < preStart) {
            return null;
        }
        if (preEnd == preStart) {
            return new TreeNode(preorder[preStart]);
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int leftRootIdxInPostorder = record.get(preorder[preStart+1]);
        int leftLen = leftRootIdxInPostorder - postStart + 1;
        root.left = dfs(record, preorder, postorder, preStart+1, preStart+leftLen, postStart, leftRootIdxInPostorder);
        root.right = dfs(record, preorder, postorder, preStart+leftLen+1, preEnd, leftRootIdxInPostorder+1, postEnd-1);
        return root;
    }

    public static void main(String[] args) {
        new Solution2825().constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
    }
}
