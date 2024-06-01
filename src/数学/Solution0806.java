package 数学;

import java.util.List;

public class Solution0806 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        recur(A.size(), A, B, C);
    }

    private void recur(int size, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (size == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        recur(size-1, A, C, B);
        C.add(A.remove(A.size() - 1));
        recur(size-1, B, A, C);
    }
}
