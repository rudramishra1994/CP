class Solution {
    int [][] dp;
    public int maxProfit(int[] prices) {
       int profit = 0;
       for(int i = 1 ; i < prices.length;i++){
           if(prices[i] > prices[i-1]) profit += prices[i] - prices[i-1];
       }
       return profit;
    }


    //This is the generic approach for Best time to buy and sell stock
    // private int maxProfit(int []prices,int day,int buying){
    //     if(day > prices.length-1) return 0;
    //     if(dp[day][buying]!=-1) return dp[day][buying];
    //     if(buying == 1){
    //         return dp[day][buying] = Math.max(maxProfit(prices,day+1,1),maxProfit(prices,day+1,0)-prices[day]);
    //     }else {
    //         return dp[day][buying] = Math.max(maxProfit(prices,day+1,0),maxProfit(prices,day+1,1)+prices[day]);
    //     }
    // }

}