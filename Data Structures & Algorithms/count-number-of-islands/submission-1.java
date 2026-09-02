class Solution {
    public void bfs(char[][] grid, int i, int j, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        int[] dirx = new int[]{0, 1, 0, -1};
        int[] diry = new int[]{1, 0, -1, 0};
        visited[i][j] = true;
        while(!queue.isEmpty()){    
            int[] node = queue.poll(); //pop the unvisited nodes coordinates
            for(int t = 0; t < 4; t++){
                int x = node[0] + dirx[t];
                int y = node[1] + diry[t];
                if(x < grid.length && y < grid[0].length && x >=0 && y>=0){
                    if(grid[x][y] == '1' && !visited[x][y]){
                        visited[x][y] = true;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int count = 0; //counts the number of islands
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && grid[i][j] != '0'){
                    bfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
}
