class UnionFind{
    int[] parent;
    int[] rank;
    public UnionFind(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x){
        if(parent[x] != x){
           parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int a, int b){
        int ra = find(a);
        int rb = find(b);
        if(ra == rb) return false;
        if(rank[ra] > rank[rb]){
            parent[rb] = ra;
        }else if(rank[rb] > rank[ra]){
            parent[ra] = rb;
        }else{
            parent[rb] = ra;
            rank[ra]++;
        }
        return true;
    }

    public boolean connected(int a, int b) {
        return find(a) == find(b);
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;
        UnionFind uf = new UnionFind(n);
        for(int[] edge: edges){
            if(!uf.union(edge[0], edge[1])){
                return false;
            }
        }
        return true;
    }
}
