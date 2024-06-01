package 字符串算法;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//KMP
//lanqiaoOJ题号1203【题目描述】小明有两个字符串，分别为S、T。请你求出T字符串的前缀在S串中出现的最长长度为多少。
public class LanQiaoOJ1203 {
    public int longestPrefix(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int ans = 0;
        int[] next = getNext(t);
        int j = 0;
        for (int i = 0 ; i < len1 ; i++) {
            while (j > 0 && s.charAt(i) != t.charAt(j)) {
                j = next[j];
            }
            if (s.charAt(i) == t.charAt(j)) {
                j++;
                ans = Math.max(ans, j);
            }
            if (j == len2) {
                break;
            }
        }
        return ans;
    }

    private int[] getNext(String t) {
        int[] next = new int[t.length()+1];
        next[0] = 0;
        next[1] = 0;
        for (int i = 1 ; i < t.length() ; i++) {
            int j = next[i];
            while (j > 0 && t.charAt(j) != t.charAt(i)) {
                j = next[j];
            }
            if (t.charAt(i) == t.charAt(j)) {
                next[i+1] = j + 1;
            } else {
                next[i+1] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        LanQiaoOJ1203 a = new LanQiaoOJ1203();
        System.out.println(a.longestPrefix("asderdeccfdvwwas", "derdeccmcedwew"));
    }
}
