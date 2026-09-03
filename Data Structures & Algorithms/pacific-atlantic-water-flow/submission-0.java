class Solution {
    private void dfs(int[][] heights, int i, int j, boolean[][] ocean){
        ocean[i][j] = true;
        int[] dirx = new int[]{0, 1, 0, -1};
        int[] diry = new int[]{1, 0, -1, 0};
        for(int t = 0; t < 4; t++){
            int x = i + dirx[t], y = j + diry[t];
            if(x >= 0 && y >=0 && x < heights.length && y < heights[0].length){
                if(!ocean[x][y] && heights[x][y] >= heights[i][j]){
                    dfs(heights, x, y, ocean);
                }
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] atlantic = new boolean[m][n];
        boolean[][] pacific = new boolean[m][n];
        for(int i = 0; i < m; i++){
            dfs(heights, i, 0, pacific);
            dfs(heights, i, n - 1, atlantic);
        }
        for(int j = 0; j < n; j++){
            dfs(heights, 0, j, pacific);
            dfs(heights, m - 1, j, atlantic);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(atlantic[i][j] && pacific[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
}
