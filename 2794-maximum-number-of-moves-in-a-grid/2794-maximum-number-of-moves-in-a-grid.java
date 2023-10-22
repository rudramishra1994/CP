class Solution {
    int [][] dp ;
    public int maxMoves(int[][] grid) {
        int maxCount = 0;
        dp = new int [grid.length][grid[0].length];
        for(int [] row : dp) Arrays.fill(row,-1);
        for(int i = 0 ;i < grid.length;i++){
            maxCount = Math.max(maxCount,dfs(grid,i,0,-1));
        }
        return maxCount -1 ;

    }
    private int dfs(int [][]grid,int x,int y,int val){
        if(x < 0 || x > grid.length-1 || y > grid[0].length-1 || y < 0 || val >= grid[x][y]) return 0;
        if(dp[x][y] !=-1) return dp[x][y];
        int [][] dirs = {{1,1},{0,1},{-1,1}};
        int maxVal = 0;
        for(int [] dir:dirs){
            maxVal = Math.max(maxVal,dfs(grid,x+dir[0],y+dir[1],grid[x][y]));
        }
        return dp[x][y] = 1 + maxVal;
    }

}