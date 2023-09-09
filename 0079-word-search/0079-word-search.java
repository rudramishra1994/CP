class Solution {
    private boolean found = false;
    private int m, n;
    boolean [][]visited;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for(int i = 0 ; i< m;i++){
            for(int j = 0 ; j < n ;j++){
                visited = new boolean[m][n];
                if(found) return true;
                else dfs(i,j,board,0,word);
            }
        }
        return found;

    }

    private void dfs(int x, int y , char [][]board,int pos,String word){
        if(pos == word.length()){
            found = true;
            return;
        }
        if(x <0 || x >= m || y < 0 || y >=n || visited[x][y] || board[x][y]!=word.charAt(pos)) return;
        visited[x][y] = true;
        int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int [] dir:dirs){
            int nextX = x+dir[0];
            int nextY = y+dir[1];
            if(!found) dfs(nextX,nextY,board,pos+1,word);
        }
        visited[x][y] = false;
    }   
}