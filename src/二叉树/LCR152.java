package 二叉树;

public class LCR152 {
    public boolean verifyTreeOrder(int[] postorder) {
        return recur(postorder, 0, postorder.length-1);
    }

    private boolean recur(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int i = start;
        while(i < end && postorder[i] < postorder[end]) {
            i++;
        }
        int mid = i-1;
        while (i < end && postorder[i] > postorder[end]) {
            i++;
        }
        return i == end && recur(postorder, start, mid) && recur(postorder, mid+1, end-1);
    }
}
