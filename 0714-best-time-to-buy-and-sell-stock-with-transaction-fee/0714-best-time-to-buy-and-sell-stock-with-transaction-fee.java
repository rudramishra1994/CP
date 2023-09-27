class Solution {
    int [][] dp;
    public int maxProfit(int[] prices, int fee) {
        dp = new int [prices.length][2];
        for(int []row : dp)Arrays.fill(row,-1);
        //return solve(prices,0,-1,fee);
        return topDownDp(prices,0,-1,fee);
    }

    private int solve(int [] prices , int day, int buy,int fee){

        if(day >= prices.length) return 0;
        int p1= 0 , p2 = 0 ;
        p1 = solve(prices,day+1,buy,fee);
        if(buy == -1){
            p2 = solve(prices,day+1,prices[day],fee) - prices[day] - fee;
        }else p2 = solve(prices,day+1,-1,fee) + prices[day];

        return Math.max(p1,p2);
    }
    
      private int topDownDp(int [] prices , int day, int buy,int fee){

        if(day >= prices.length) return 0;
        int status = buy == -1 ? 0 : 1;
        if(dp[day][status]!=-1) return dp[day][status];
        int p1= 0 , p2 = 0 ;
        p1 = topDownDp(prices,day+1,buy,fee);
        if(buy == -1){
            p2 = topDownDp(prices,day+1,prices[day],fee) - prices[day] - fee;
        }else p2 = topDownDp(prices,day+1,-1,fee) + prices[day];

        return dp[day][status] = Math.max(p1,p2);
    }
}