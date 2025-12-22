class Solution {
    public void solve(char[][] board) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int j = 0; j < board[0].length; j++){ 
            if(board[0][j] == 'O'){
                DFS(board, 0, j, vis);
            }
            if(board[board.length-1][j] == 'O'){
                DFS(board, board.length-1, j, vis);
            }
        }
        for(int j = 0; j < board.length; j++){ 
            if(board[j][0] == 'O'){
                DFS(board, j, 0, vis);
            }
            if(board[j][board[0].length-1] == 'O'){
                DFS(board, j, board[0].length-1, vis);
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'P'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public static void DFS(char[][] board, int i, int j, boolean[][] vis){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length){
            
            return;
        }
        if(vis[i][j] || board[i][j] == 'X'){
            return;
        }
        vis[i][j] = true;
        board[i][j] = 'P';
        DFS(board, i-1, j, vis); 
        DFS(board, i+1, j, vis); 
        DFS(board, i, j-1, vis); 
        DFS(board, i, j+1, vis); 
    }
}