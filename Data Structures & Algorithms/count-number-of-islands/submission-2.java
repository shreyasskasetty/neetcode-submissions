class Solution {
    // Islands are isolated set of graphs. A set of disconnected graphs
    // Run through each and every grid cells which are marked one and not visited and run bfs on them
    // Each bfs run will mark certain connected cells as visited. 
    // Count the number of times you have to run bfs to make all cells visited
    boolean[][] visited;

    private void bfs(char[][] grid, int i, int j){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        int[] dirx = new int[]{0, 1, 0, -1};
        int[] diry = new int[]{1, 0, -1, 0};
        
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            for(int t = 0; t < 4; t++){
                int x = dirx[t] + node[0];
                int y = diry[t] + node[1];
                if(x >= 0 && x < grid.length && y >=0 && y < grid[0].length){
                    if(grid[x][y] == '1' && !visited[x][y]){
                        visited[x][y] = true;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        int result = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    if(grid[i][j] == '1'){
                        result++;
                        bfs(grid, i, j);
                    }
                }
            }
        }
        return result;
    }
}
