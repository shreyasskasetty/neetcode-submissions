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
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length + 1);
        for(int[] edge: edges){
            if(!uf.union(edge[0], edge[1])){
                return new int[]{edge[0], edge[1]};
            }
        }
        return new int[0];
    }
}
