package 数学;

public class Solution405 {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        char[] arr = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(arr[num & 15]);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
}
