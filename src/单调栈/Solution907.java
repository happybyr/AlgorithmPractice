package 单调栈;

import javax.print.DocFlavor;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution907 {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] l = new int[n];
        int[] r = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0 ; i<n ; i++) {
            while (!stack.isEmpty() && arr[stack.peekLast()] >= arr[i]) {
                stack.pollLast();
            }
            l[i] = stack.isEmpty() ? -1 : stack.peekLast();
            stack.addLast(i);
        }
        stack.clear();
        for (int i=n-1 ; i>=0 ; i--) {
            while (!stack.isEmpty() && arr[stack.peekLast()] > arr[i]) {
                stack.pollLast();
            }
            r[i] = stack.isEmpty() ? n : stack.peekLast();
            stack.addLast(i);
        }
        long res = 0;
        for (int i=0 ; i<n ; i++) {
            res += (long)arr[i] * (r[i] - i) * (i - l[i]);
        }
        return (int)(res % 1000000007);
    }
}
