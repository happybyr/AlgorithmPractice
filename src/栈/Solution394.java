package 栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution394 {
    public String decodeString(String s) {
        Deque<Integer> multiStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        int multi = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                strStack.addLast(res.toString());
                multiStack.addLast(multi);
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                int curMulti = multiStack.removeLast();
                StringBuilder tmp = new StringBuilder();
                for (int i=0 ; i<curMulti ; i++) {
                    tmp.append(res);
                }
                String pre = strStack.isEmpty() ? "" : strStack.removeLast();
                res = new StringBuilder(pre + tmp);
            } else if (c >= '0' && c <= '9') {
                multi = multi*10 + c - '0';
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
