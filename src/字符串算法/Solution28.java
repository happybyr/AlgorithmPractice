package 字符串算法;

// KMP算法
public class Solution28 {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        int[] next = getNext(needle);
        int j = 0;
        for (int i = 0 ; i < len1 ; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == len2) {
                return i - len2 + 1;
            }
        }
        return -1;
    }

    private int[] getNext(String needle) {
        int[] next = new int[needle.length()+1];
        next[0] = 0;
        next[1] = 0;
        for (int i = 1 ; i < needle.length() ; i++) {
            int j = next[i];
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                next[i+1] = j + 1;
            } else {
                next[i+1] = 0;
            }
        }
        return next;
    }
}
