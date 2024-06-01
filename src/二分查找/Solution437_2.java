package 二分查找;

import 二叉树.TreeNode;

import java.util.HashMap;

// 前缀和解法
public class Solution437_2 {
    private HashMap<Long, Integer> map;
    private int ans;
    public int pathSum(TreeNode root, int targetSum) {
        map = new HashMap<>();
        ans = 0;
        map.put(0L, 1);
        recu(root, targetSum, 0L);
        return ans;
    }
    private void recu(TreeNode root, int targetSum, long cur){
        if(root == null) return;
        cur += root.val;
        ans += map.getOrDefault(cur - targetSum, 0);
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        recu(root.left, targetSum, cur);
        recu(root.right, targetSum, cur);
        map.put(cur, map.get(cur) - 1);
        if(map.get(cur) == 0) map.remove(cur);
        return;
    }
}
