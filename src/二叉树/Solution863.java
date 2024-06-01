package 二叉树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(graph, root);
        List<Integer> res = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(target.val);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(target.val);
        int distance = 0;
        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int i=0 ; i<size ; i++) {
                int poll = queue.poll();
                if (graph.containsKey(poll)) {
                    for(int adj : graph.get(poll)) {
                        if (!visited.contains(adj)) {
                            visited.add(adj);
                            queue.offer(adj);
                        }
                    }
                }
            }
            if (distance == k) {
                res.addAll(queue);
                break;
            }
        }
        return res;
    }
    private void buildGraph(Map<Integer, List<Integer>> graph , TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            List<Integer> list = graph.getOrDefault(root.val, new ArrayList<>());
            list.add(root.left.val);
            graph.put(root.val, list);

            list = graph.getOrDefault(root.left.val, new ArrayList<>());
            list.add(root.val);
            graph.put(root.left.val, list);
            buildGraph(graph, root.left);
        }
        if (root.right != null) {
            List<Integer> list = graph.getOrDefault(root.val, new ArrayList<>());
            list.add(root.right.val);
            graph.put(root.val, list);

            list = graph.getOrDefault(root.right.val, new ArrayList<>());
            list.add(root.val);
            graph.put(root.right.val, list);
            buildGraph(graph, root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        System.out.println(new Solution863().distanceK(root, root.left, 2));
    }
}
