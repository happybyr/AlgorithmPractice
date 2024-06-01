package 并查集;

public class Solution200 {
    static class UnionFind {
        int count;
        int[] root;
        public UnionFind (int size) {
            root = new int[size];
            for (int i=0 ; i<size ; i++) {
                root[i] = i;
            }
            count = size;
        }

        private int find(int x) {
            if (root[x] == x) {
                return x;
            }
            root[x] = find(root[x]);
            return root[x];
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot != yRoot) {
                root[yRoot] = root[xRoot];
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

    private int[][] direct = {{1, 0}, {0, 1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        UnionFind u = new UnionFind(m*n);
        int space = 0;
        for (int i=0 ; i<m ; i++) {
            for (int j=0 ; j<n ; j++) {
                if (grid[i][j] == '0') {
                    space++;
                } else {
                    for (int[] dir : direct) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x < m && y < n && grid[x][y] == '1') {
                            u.union(getIndex(i, j, n), getIndex(x, y, n));
                        }
                    }
                }
            }
        }
        return u.getCount() - space;
    }

    private int getIndex(int x, int y, int n) {
        return x*n + y;
    }

    public static void main(String[] args) {
        int res = new Solution200().numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}});
        System.out.println(res);
    }
}
