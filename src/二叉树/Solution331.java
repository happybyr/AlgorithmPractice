package 二叉树;

public class Solution331 {
    public boolean isValidSerialization(String preorder) {
        if ("#".equals(preorder)) {
            return true;
        }
        int indegree = 0, outdegree = 0;
        String[] arr = preorder.split(",");
        for (int i=0 ; i<arr.length ; i++) {
            String c = arr[i];
            if (i == 0 && "#".equals(c)) {
                return false;
            }
            if (i == 0) {
                outdegree += 2;
                continue;
            }
            if ("#".equals(c)) {
                indegree++;
            } else {
                outdegree += 2;
                indegree++;
            }

            if (i != arr.length-1 && outdegree <= indegree) {
                return false;
            }
        }
        return indegree == outdegree;
    }
}
