package 双指针;

public class Solution2730 {
    public int longestSemiRepetitiveSubstring(String s) {
        int cnt = 0;
        int ans = 1;
        int same = 0;
        int start = 0;
        int n = s.length();
        for (int end = 1 ; end < n ; end++) {
            if (s.charAt(end) == s.charAt(end-1)) {
                cnt++;
                if (cnt > 1) {
                    start = same;
                    cnt = 1;
                }
                same = end;
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }

    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i=1 ; i<=n ; i++) {
            if (isPunishmentNumber(i, 0, 0)) {
                ans += i*i;
                System.out.println("i*i" + i*i);
            }
        }
        return ans;
    }

    private boolean isPunishmentNumber(int num, int cur, int start) {
        int square = num*num;
        if (start == String.valueOf(square).length()) {
            return cur == num;
        }
        String value = String.valueOf(square);
        int x = 0;
        for (int i=start ; i<value.length() ; i++) {
            x = x*10 + value.charAt(i) - '0';
            if (isPunishmentNumber(num, cur + x, i+1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Solution2730().punishmentNumber(37);
    }
}
