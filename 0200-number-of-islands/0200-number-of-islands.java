class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j < m ; j++){
                if(grid[i][j] != 'v' && grid[i][j] =='1'){
                    DFS(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }
    private void DFS(int x,int y,char[][]grid){
        int n = grid.length;
        int m = grid[0].length;
        if(x < 0 || x > n-1 || y < 0 || y > m-1 ||grid[x][y] == 'v') return;
        int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        if(grid[x][y] == '0'){
            grid[x][y] = 'v';
            return;
        }
        for(int [] dir : dirs){
            if(grid[x][y] =='1') grid[x][y] = 'v';
            DFS(x+dir[0],y+dir[1],grid);
        }

    }
}