package 二叉树;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IteratedTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode pop = stack.pop();
            list.add(pop.val);
            cur = pop.right;
        }
        return list;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                list.add(cur.val);
                cur = cur.left;
            }
            TreeNode pop = stack.pop();
            cur = pop.right;
        }
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.peek();
            if (cur.right != null && cur.right != pre) {
                cur = cur.right;
            } else {
                stack.pop();
                list.add(cur.val);
                pre = cur;
                cur = null;
            }
        }
        return list;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.right;
            }
            TreeNode pop = stack.pop();
            cur = pop.left;
        }

        for (int i=0, j=list.size()-1 ; i < j ; i++, j--) {
            int tmp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, tmp);
        }
        return list;
    }

    public List<Integer> postorderTraversal3(TreeNode root) {
        Stack<Pair<TreeNode, Boolean>> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(new Pair<>(root, false));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Boolean> pop = stack.pop();
            TreeNode cur = pop.getKey();
            boolean flag = pop.getValue();
            if (!flag) {
                stack.push(new Pair<>(cur, true));
                if (cur.right != null) {
                    stack.push(new Pair<>(cur.right, false));
                }
                if (cur.left != null) {
                    stack.push(new Pair<>(cur.left, false));
                }
            } else {
                list.add(cur.val);
            }
        }
        return list;
    }

    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Pair<Integer, Node>> stack = new Stack<>();
        stack.push(new Pair<>(0, root));
        while (!stack.isEmpty()) {
            Pair<Integer, Node> pop = stack.pop();
            int cnt = pop.getKey();
            Node cur = pop.getValue();
            if (cur == null) {
                continue;
            }
            if (cnt == cur.children.size()) {
                ans.add(cur.val);
            } else {
                stack.push(new Pair<>(cnt + 1, cur));
                stack.push(new Pair<>(0, cur.children.get(cnt)));
            }
        }
        return ans;
    }

//         1
//     2        3
//  4     5 null   6

    public static void main(String[] args) {
        IteratedTraversal it = new IteratedTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(it.inorderTraversal(root));
        System.out.println(it.preorderTraversal(root));
        System.out.println(it.postorderTraversal(root));
        System.out.println(it.postorderTraversal2(root));
        System.out.println(it.postorderTraversal3(root));
    }


}
