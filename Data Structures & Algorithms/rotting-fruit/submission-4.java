class Solution {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int mins = 0;
        while(!queue.isEmpty()){

            int size = queue.size();
            int[] dirx = {0, 1, 0, -1};
            int[] diry = {1, 0, -1, 0};
            mins += 1;
            for(int z = 0; z < size; z++){

                int[] curr = queue.poll();

                for(int t=0; t < 4; t++){
                    int x = curr[0] + dirx[t];
                    int y = curr[1] + diry[t];
                    if(x < m && y < n && x >= 0 && y >= 0){
                        if(grid[x][y] == 1){
                            queue.offer(new int[]{x, y});
                            grid[x][y] = 2;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return mins == 0? 0: mins-1;
    }
}
