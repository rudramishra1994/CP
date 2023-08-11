class Solution {
    int [][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length+1][2];
        for(int [] arr : dp) Arrays.fill(arr,-1);
        return maxProfit(prices,0,1);    
    }

    private int maxProfit(int []prices,int day,int buying){
        if(day > prices.length-1) return 0;
        if(dp[day][buying]!=-1) return dp[day][buying];
        if(buying == 1){
            return dp[day][buying] = Math.max(maxProfit(prices,day+1,1),maxProfit(prices,day+1,0)-prices[day]);
        }else {
            return dp[day][buying] = Math.max(maxProfit(prices,day+1,0),maxProfit(prices,day+1,1)+prices[day]);
        }
    }

}