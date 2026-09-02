class Solution {
    private int bfs(int[][] grid, int[] source, boolean[][] visited){
        int area = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(source);
        visited[source[0]][source[1]] = true;
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int[] dirx = {0, 1, 0, -1};
            int[] diry = {1, 0, -1, 0};
            for(int t = 0; t < 4; t++){
                int x = node[0] + dirx[t];
                int y = node[1] + diry[t];
                if(x < grid.length && y < grid[0].length && x>=0 && y>=0){
                    if(!visited[x][y] && grid[x][y] == 1){
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                        area++;
                    }
                }
            }
        }
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    maxArea = Math.max(bfs(grid, new int[]{i, j}, visited), maxArea);
                }
            }
        }
        return maxArea;
    }
}
