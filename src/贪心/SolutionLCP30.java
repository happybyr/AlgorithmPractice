package 贪心;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionLCP30 {
    public int magicTower(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < 0) {
            return -1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int ans = 0;
        long hp = 1;
        for (int i=0 ; i<n ; i++) {
            if (nums[i] < 0) {
                queue.add(nums[i]);
            }
            hp += nums[i];
            if (hp <= 0) {
                hp -= queue.poll();
                ans++;
            }
        }
        return ans;
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

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<Pair<TreeNode, TreeNode>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, null));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int fx = 0, fy = 0;
            TreeNode[] candidates = new TreeNode[2];
            for (int i=0 ; i<size ; i++) {
                Pair<TreeNode, TreeNode> polled = queue.poll();
                if (polled.getKey().val == x) {
                    fx = 1;
                    candidates[0] = polled.getValue();
                }
                if (polled.getKey().val == y) {
                    fy = 1;
                    candidates[1] = polled.getValue();
                }
                if (polled.getKey().left != null) {
                    queue.add(new Pair<>(polled.getKey().left, polled.getKey()));
                }
                if (polled.getKey().right != null) {
                    queue.add(new Pair<>(polled.getKey().right, polled.getKey()));
                }
            }

            if ((fx|fy) == 0) {
                continue;
            } else if ((fx ^ fy) == 1) {
                return false;
            } else if ((fx & fy) == 1) {
                return candidates[0] != candidates[1];
            }
        }
        return false;
    }
}
