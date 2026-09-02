class Solution {

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int[] dirx = new int[]{0, 1, 0, -1};
            int[] diry = new int[]{1, 0, -1, 0};
        
            for(int t = 0; t <4; t++){
                int x = node[0] + dirx[t];
                int y = node[1] + diry[t];
                if(x < grid.length && y < grid[0].length && x >=0 && y>=0){   
                    if(grid[x][y] == Integer.MAX_VALUE){
                        grid[x][y] = grid[node[0]][node[1]] + 1;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }
}
