package 回溯DFS相关;

import javax.print.DocFlavor;

import java.util.ArrayList;
import java.util.List;

public class Solution679 {
    boolean isValid = false;
    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>(4);
        for (int card : cards) {
            list.add((double) card);
        }
        return dfs(list);
    }

    private boolean dfs(List<Double> origin) {
        if (origin.size() == 1) {
            if (Math.abs(origin.get(0)-24) < 0.00000001) {
                isValid = true;
                return true;
            }
            return false;
        }
        for (int i=0 ; i<origin.size() ; i++) {
            for (int j=i+1 ; j<origin.size() ; j++) {
                List<Double> list = new ArrayList<>(origin);
                double a = list.remove(j);
                double b = list.remove(i);
                list.add(a+b);
                isValid |= dfs(list);
                list.set(list.size()-1, a-b);
                isValid |= dfs(list);
                list.set(list.size()-1, a*b);
                isValid |= dfs(list);
                list.set(list.size()-1, a/b);
                isValid |= dfs(list);
                list.set(list.size()-1, b/a);
                isValid |= dfs(list);
                list.set(list.size()-1, b-a);
                isValid |= dfs(list);
                if (isValid) {
                    return true;
                }
            }
        }
        return isValid;
    }
}
