package n叉树遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javafx.util.Pair;

public class Solution590 {

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
}
