class Solution {
    class UnionFind {
        int[] parent;
        
        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }
    
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(4 * n * n);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int root = 4 * (i * n + j);
                char val = grid[i].charAt(j);
                
                if (val == '/' || val == ' ') {
                    uf.union(root + 0, root + 3);
                    uf.union(root + 1, root + 2);
                }
                if (val == '\\' || val == ' ') {
                    uf.union(root + 0, root + 1);
                    uf.union(root + 2, root + 3);
                }
                
                if (j + 1 < n) {
                    uf.union(root + 1, root + 7);
                }
                if (i + 1 < n) {
                    uf.union(root + 2, root + 4 * n);
                }
            }
        }
        
        int regions = 0;
        for (int i = 0; i < 4 * n * n; i++) {
            if (uf.find(i) == i) regions++;
        }
        
        return regions;
    }
}