class Solution {
    int [][]dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int [n+1][n+1];
        for(int [] row : dp) Arrays.fill(row,-1);
        return solve(nums,0,-1);
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