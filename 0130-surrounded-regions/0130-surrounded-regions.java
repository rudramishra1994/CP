class Solution {
    //char [][] board;
    public void solve(char[][] board) {
        //this.board = board;
        int [] row = {0,board.length-1};
        int [] col = {0,board[0].length-1};
        for(int i : row){
            for(int j = 0 ; j < board[0].length ;j++) {
                if(board[i][j] == 'O'){
                    DFS(i,j,board);
                }
            }
        }
        for(int i = 0 ; i < board.length ;i++){
            for(int j : col) {
                if(board[i][j] == 'O'){
                    DFS(i,j,board);
                }
            }
        }
        for(int i = 0 ; i < board.length ;i++){
            for(int j = 0 ; j < board[0].length;j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'v') board[i][j] = 'O';
                
            }
        }
        //board = this.board;
    }
    private void  DFS(int x,int y, char [][]board){
       if(x < 0 || y < 0 || x >board.length-1 || y > board[0].length-1 || board[x][y] == 'X' || board[x][y]=='v') return;
       board[x][y] ='v';
       int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
       for(int [] dir : dirs){
           DFS(x+dir[0],y+dir[1],board);
       } 
    }
}