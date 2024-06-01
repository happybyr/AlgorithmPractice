package 二叉树;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution662 {
    public int widthOfBinaryTree(TreeNode root) {
        int res = 1;
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayDeque<Integer> index = new ArrayDeque<>();
        queue.add(root);
        index.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0 ; i<size ; i++) {
                TreeNode node = queue.poll();
                int cur = index.pollFirst();
                if (node.left != null) {
                    queue.add(node.left);
                    index.add(2*cur+1);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    index.add(2*cur+2);
                }
            }
            if (index.size() > 0) {
                res = Math.max(res, index.peekLast()-index.peekFirst()+1);
            }
        }
        return res;
    }
}
