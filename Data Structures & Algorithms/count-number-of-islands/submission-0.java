class Solution {
    public void bfs(char[][] grid, int[] p, int[][] visited, int m, int n){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(p);
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while(!queue.isEmpty()){
            int[] pt = queue.poll();
            visited[pt[0]][pt[1]] = 1;
            for(int i = 0; i < dir.length; i++){
                int[] neigh = new int[]{pt[0] + dir[i][0],pt[1] + dir[i][1]};
                //neighbors
                if((0 <= neigh[0] && neigh[0] < m) &&  (0 <= neigh[1] && neigh[1] < n)
                    && grid[neigh[0]][neigh[1]] == '1'){
                    if(visited[neigh[0]][neigh[1]] != 1){
                        queue.add(neigh);
                    }
                }
                
            }
        }
       
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //loop through each coordinate and run bfs from the cell which has 1
                int[] p = new int[]{i, j};
                if(visited[i][j] == 0 && grid[i][j] == '1'){
                    //bfs marks the isolated islands as visited
                    //count gives the number of islands
                    count++;
                    bfs(grid, p, visited, m, n);
                }
            }
        }
        return count;
    }
}
