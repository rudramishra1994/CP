class Solution {
    int MAX_COUNT = 999999;
    int [] dp;
    public int coinChange(int[] coins, int amount) {
        
        this.dp = new int [amount+1];
        Arrays.fill(this.dp,-1);
        this.dp[0] = 0;
        int count = countCoin(coins,amount);
        return count >= MAX_COUNT ? -1 :count;

    }

    public int countCoin(int [] coins,int amount){
        if(amount == 0) return 0;
        if(dp[amount]!=-1) return dp[amount];
        int count = MAX_COUNT;
        for(int coin : coins){
            if(amount >= coin){
                count = Math.min(count,countCoin(coins,amount-coin));
            }
        }
        return dp[amount] =  1+count;
    }
}