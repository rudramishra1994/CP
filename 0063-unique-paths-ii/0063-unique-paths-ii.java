class Solution {
    int [][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        dp = new int [m][n];
        for(int [] row : dp) Arrays.fill(row,-1);
        return topDownDp(obstacleGrid,0,0);


    }

    private int topDownDp(int [][] obstacleGrid,int row,int col){
        if(row >=obstacleGrid.length || col >=obstacleGrid[0].length || obstacleGrid[row][col] ==1) return 0;
        if(row == obstacleGrid.length-1 && col ==obstacleGrid[0].length-1) return 1;
        if(dp[row][col] !=-1) return dp[row][col];    
        return dp[row][col] = topDownDp(obstacleGrid,row+1,col) + topDownDp(obstacleGrid,row,col+1);

    }
}