class Solution {
    public int tribonacci(int n) {
        int t0 = 0,t1 = 1,t2=1;
        int [] dp = new int []{0,1,1};
        if(n < 3) return dp [n];
        int t3 = 0;
        for(int i = 3 ; i <= n; i++){
            t3 = dp[2]+dp[1]+dp[0];
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = t3;
        }
        return t3;
    }
}