class Solution {
    public void dfs(char[][] board, int i , int j, 
                boolean[][] visited, boolean flag){
        visited[i][j] = true;
        int[] dirx = new int[]{0, 1, 0, -1};
        int[] diry = new int[]{1, 0, -1, 0};
        if(flag){
            board[i][j] = 'X';
        }
        for(int t = 0; t < 4; t++){
            int x = i + dirx[t];
            int y = j + diry[t];
            if(x >=0 && y >=0 && x < board.length && y < board[0].length){
                if(visited[x][y]) continue;
                if(board[x][y] == 'O')
                    dfs(board, x, y, visited, flag);
            }
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O')     dfs(board, i, 0, visited, false);
            if(board[i][n-1] == 'O')   dfs(board, i, n-1, visited, false);
        }
        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O')     dfs(board, 0, j, visited, false);
            if(board[m-1][j] == 'O')   dfs(board, m-1, j, visited, false);
        }
        for(int i = 0; i < m; i++){
            for(int j =0; j < n; j++){
                if(board[i][j] == 'O' && !visited[i][j]){
                   board[i][j] = 'X';
                }
            }
        }
    }
}
