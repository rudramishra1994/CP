class Solution {
    int dp[][];
    public int maxProfit(int[] prices) {
        dp = new int [prices.length][2];
        for(int [] row : dp) Arrays.fill(row,-1);
        //return solve(prices,0,-1);
        return topDownDp(prices,0,-1);
    }

    private int solve(int [] prices,int day,int buy){
        if(day >= prices.length) return 0;
        
        int p1 = 0, p2 = 0;
        if(buy == -1){//currently holding no stocks
            p1 = solve(prices,day+1,prices[day]) - prices[day];
        }else{
            p1 = solve(prices,day+2,-1) + prices[day];
        }

        p2 = solve(prices,day+1,buy);

        return Math.max(p1,p2);

    }

    private int topDownDp(int [] prices,int day,int buy){
        if(day >= prices.length) return 0;
        int status = buy == -1 ? 0 : 1;
        if(dp[day][status]!=-1) return dp[day][status];
        int p1 = 0, p2 = 0;
        if(buy == -1){//currently holding no stocks
            p1 = topDownDp(prices,day+1,prices[day]) - prices[day];
        }else{
            p1 = topDownDp(prices,day+2,-1) + prices[day];
        }

        p2 = topDownDp(prices,day+1,buy);

        return dp[day][status] = Math.max(p1,p2);

    }
}