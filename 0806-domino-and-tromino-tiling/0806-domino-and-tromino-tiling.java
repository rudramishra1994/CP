/*
f(n) = f(n-1)+f(n-2)+2f(n-3)+2f(n-4)+2f(n-5) + ... + 2f(0) ...i
f(n-1) = f(n-2)+f(n-3)+2f(n-4)+2f(n-5)+...+2f(0) ...ii

subtracting equation ii from i we get
f(n) = 2f(n-1) + f(n-3) [recurrence relation]

*/
class Solution {
    public int numTilings(int n) {

        if(n <= 2) return n;
        int MOD = 1000000007;
        int [] dp = new int[n+1];
    
        dp[1] = 1; dp[2] = 2; dp[3] = 5;
        for(int i = 4 ; i < n+1 ; i++){
            dp[i] = ((2 * dp[i-1])%MOD + (dp[i-3])%MOD)%MOD;
        }

        return (int)dp[n] % MOD;
        
    }
}