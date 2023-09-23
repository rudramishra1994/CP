class Solution {
    int [][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        dp = new int [triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int [] arr : dp)
        Arrays.fill(arr,Integer.MAX_VALUE);
        //return backtrack(triangle,0,0);
        return topDownDP(triangle,0,0);
    }



    public int backtrack(List<List<Integer>> triangle , int prev, int row){
        if(row >=triangle.size()) return 0;
        return  triangle.get(row).get(prev) + 
                Math.min(backtrack(triangle,prev,row+1),backtrack(triangle,prev+1,row+1));
    }

    public int topDownDP(List<List<Integer>> triangle , int prev, int row){
        if(row >=triangle.size()) return 0;
        if(dp[row][prev]!=Integer.MAX_VALUE) return dp[row][prev];
        return dp[row][prev] = triangle.get(row).get(prev) + 
                Math.min(topDownDP(triangle,prev,row+1),topDownDP(triangle,prev+1,row+1));
    }
}