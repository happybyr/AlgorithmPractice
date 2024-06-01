package 栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution71 {
    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        String[] strs = path.split("/");
        for (String str : strs) {
            if ("..".equals(str)) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else if (".".equals(str) || "".equals(str)) {
                continue;
            } else {
                deque.addLast(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append("/");
            sb.append(deque.pollFirst());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
