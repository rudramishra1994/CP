class Solution {
    int [][]dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // dp = new int [n+1][n+1];
        // for(int [] row : dp) Arrays.fill(row,-1);
        // return solve(nums,0,-1);

        int [] dp = new int [n+1];
        int maxLIS = 1;
        dp[0] = 0;
        Arrays.fill(dp,1);
        for(int i = 1; i <n ;i++){
            for(int j = 0; j <i ; j++ ){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    
                }
                
            }
            maxLIS = Integer.max(maxLIS,dp[i]);
        }
        return maxLIS;

    }




    private int solve(int [] nums,int start,int prev){
        if(nums.length < 2) return nums.length;
        if(start >=nums.length) return 0;
        int lis = 1;
        int include = 0;
        int exclude = 0;
        if(prev!=-1 &&dp[start][prev]!=-1) return dp[start][prev];
        if(prev ==-1 || nums[start] > nums[prev]) include = 1 + solve(nums,start+1,start);
        exclude = solve(nums,start+1,prev);
        if(prev!=-1)
            return dp[start][prev] = Math.max(include,exclude);
        return Math.max(include,exclude);
    }
}