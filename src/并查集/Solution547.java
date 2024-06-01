package 并查集;

public class Solution547 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i=0 ; i<n ; i++) {
            for (int j=0 ; j<n ; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }

    class UnionFind {
        int[] parent;
        int count;

        public UnionFind(int count) {
            this.count = count;
            parent = new int[count];
            for (int i = 0; i < count; i++) {
                parent[i] = i;
            }
        }

        public int find (int x) {
            if (parent[x] == x) {
                return parent[x];
            }
            return parent[x] = find(parent[x]);
        }

        public void union (int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
                count--;
            }
        }

        public int getCount() {
            return this.count;
        }
    }
}
