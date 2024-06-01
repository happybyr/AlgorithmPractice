package n叉树遍历;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class Solution589 {
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

    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            ans.add(node.val);
            for (int i=node.children.size()-1 ; i >=0 ; i--) {
                stack.push(node.children.get(i));
            }
        }
        return ans;
    }

    public List<Integer> preorder2(Node root) {
        List<Integer> ans = new ArrayList<>();
        Deque<Object[]> d = new ArrayDeque<>();
        d.addLast(new Object[]{root, 0});
        while (!d.isEmpty()) {
            Object[] poll = d.pollLast();
            Node t = (Node)poll[0]; Integer cnt = (Integer)poll[1];
            if (t == null) continue;
            if (cnt == 0) ans.add(t.val);
            if (cnt < t.children.size()) {
                d.addLast(new Object[]{t, cnt + 1});
                d.addLast(new Object[]{t.children.get(cnt), 0});
            }
        }
        return ans;
    }
}
