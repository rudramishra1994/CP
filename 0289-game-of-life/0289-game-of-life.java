class Solution {
    public void gameOfLife(int[][] board) {
        int [][] dirs = {{-1,0},{1,1},{0,1},{-1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        Set<Integer> alive = new HashSet<>(Arrays.asList(1,999,-999));
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                int count = 0;
                for(int [] dir : dirs){
                        int nextX = i+dir[0];
                        int nextY = j+dir[1];
                        if((0<=nextX && nextX < n && 0<=nextY && nextY < m) && alive.contains(board[nextX][nextY])) count++;
                }
                if(board[i][j] == 1 && (count < 2 || count > 3)) board[i][j] = -999;
                else if(board[i][j] == 1 && count <= 3) board[i][j] = 999;
                else if(board[i][j] == 0 && count == 3) board[i][j] = 9999;
            }
        }
        for(int i = 0; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j] ==-999) board[i][j] = 0;
                else if(board[i][j] >= 999) board[i][j] = 1;
            }
        }
    }

    private boolean isValid(int nextX,int nextY,int n,int m){
        if(0<=nextX && nextX < n && 0<=nextY && nextY < m) return true;
        return false;
    }

    private boolean isAlive(int boardVal){
        Set<Integer> alive = new HashSet<>(Arrays.asList(1,999,-999));
        if(alive.contains(boardVal)) return true;
        return false;
    }
}