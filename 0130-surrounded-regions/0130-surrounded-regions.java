class Solution {

    int[][] dir = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        boolean[][] vis = new boolean[m][n];

        for(int i = 0; i < m; i++) {

            if(board[i][0] == 'O' && !vis[i][0]) {
                dfs(board, vis, i, 0);
            }

            if(board[i][n - 1] == 'O' && !vis[i][n - 1]) {
                dfs(board, vis, i, n - 1);
            }
        }

        for(int j = 0; j < n; j++) {

            if(board[0][j] == 'O' && !vis[0][j]) {
                dfs(board, vis, 0, j);
            }

            if(board[m - 1][j] == 'O' && !vis[m - 1][j]) {
                dfs(board, vis, m - 1, j);
            }
        }

        for(int i = 0; i < m; i++) {

            for(int j = 0; j < n; j++) {

                if(board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }


    public void dfs(char[][] board, boolean[][] vis, int r, int c) {
        vis[r][c] = true;

        for(int[] d : dir) {

            int nr = r + d[0];
            int nc = c + d[1];

            if(nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length && board[nr][nc] == 'O' && !vis[nr][nc]) {

                dfs(board, vis, nr, nc);
            }
        }
    }
}