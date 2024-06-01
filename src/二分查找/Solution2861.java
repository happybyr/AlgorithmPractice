package 二分查找;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution2861 {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int ans = 0;
        int mx = Collections.min(stock) + budget/n;
        int[] stocks = stock.stream().mapToInt(i -> i).toArray();
        int[] costs = cost.stream().mapToInt(i -> i).toArray();
        for (List<Integer> comp : composition) {
            int[] comps = comp.stream().mapToInt(i -> i).toArray();
            int left = ans, right = mx + 1;     // 小于等于left 可以制造  大于等于right不能制造
            while (left + 1 < right) {
                long money = 0;
                boolean ok = true;
                int mid = (left + right) / 2;
                for (int i=0 ; i<n ; i++) {
                    if ((long)comps[i] * mid > stocks[i]) {
                        money += ((long) comps[i] * mid - stocks[i]) * costs[i];
                    }
                    if (money > budget) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            ans = left;
        }
        return ans;
    }
}
