package 回溯DFS相关;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCR157 {
    public String[] goodsOrder(String goods) {
        char[] arr = goods.toCharArray();
        Arrays.sort(arr);
        boolean[] visited = new boolean[arr.length];
        List<String> res = new ArrayList<>();
        dfs(arr, res, new StringBuilder(), visited);
        String[] ans = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private void dfs(char[] arr, List<String> res, StringBuilder sb, boolean[] visited) {
        if (sb.length() == arr.length) {
            res.add(sb.toString());
            return;
        }
        for (int i=0 ; i<arr.length ; i++) {
            if (visited[i] || (i > 0 && arr[i] == arr[i-1] && !visited[i-1])) {
                continue;
            }
            sb.append(arr[i]);
            visited[i] = true;
            dfs(arr, res, sb, visited);
            visited[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
