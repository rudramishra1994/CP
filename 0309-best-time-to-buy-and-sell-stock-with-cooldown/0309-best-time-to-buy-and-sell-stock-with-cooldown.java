
/**
    Pure recursion gives TLE;
 */
class Solution {
    int [][] dp = new int [5001][2];
    public int maxProfit(int[] prices) {
        for(int [] arr : dp) Arrays.fill(arr,-1);
        return findMaxProfit(prices,0,true);
        
    }

    private int findMaxProfit(int []prices, int day ,boolean cooldown){
        if(day >= prices.length)  return 0;
        int k = cooldown ? 1 : 0;
        if(dp[day][k] != -1) return dp[day][k];
        if(cooldown) return dp[day][k] = Math.max(findMaxProfit(prices,day+1,false)-prices[day],findMaxProfit(prices,day+1,true));
        else return dp[day][k] = Math.max(findMaxProfit(prices,day+2,true)+prices[day],findMaxProfit(prices,day+1,false));

    }
}