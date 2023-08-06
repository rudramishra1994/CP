

/*
Plain recursion gives TLE

class Solution {
  
    public int uniquePaths(int m, int n) {
        return findUniquePath(0,0,m,n);
    }
    private int findUniquePath(int x,int y, int m,int n){
        if(x >m-1 || y >n-1) return 0;
        if(x == m-1 && y == n-1) return 1;
        return findUniquePath(x+1,y,m,n) + findUniquePath(x,y+1,m,n);

    }
}

*/


class Solution {
  
    public int uniquePaths(int m, int n) {
       int [][] dp = new int[m][n];
       for(int i = 0; i < m; i++) dp[i][0] = 1;
       for(int j = 0; j < n; j++) dp[0][j] = 1;

       for(int i = 1 ; i  < m ; i++){
           for(int j = 1 ; j < n ; j++){
               dp[i][j] = dp[i-1][j] + dp[i][j-1];
           }
       }
       return dp[m-1][n-1];

    }
    
}