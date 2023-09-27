class Solution {
    int [][][] dp ;
    public int maxProfit(int k, int[] prices) {
        dp = new int [prices.length][2][k+1];
        for(int i = 0 ; i < prices.length ;i++){
            for(int j = 0 ; j < 2;j++){
                for(int l = 0 ; l < k+1;l++){
                    dp[i][j][l] = Integer.MIN_VALUE;
                }
            }
        }
        //return backtrack(prices,0,-1,0,k);
        return topDownDP(prices,0,-1,0,k);
        //return bottomUpDP(prices);
    }




   


    private int backtrack(int [] prices,int day,int buy,int transaction,int k){
        if(day >= prices.length || transaction >=k) return 0;

        int p1= 0, p2 =0;

        p1 = backtrack(prices,day+1,buy,transaction,k);

        if(buy == -1){
            p2 = backtrack(prices,day+1,prices[day],transaction,k)-prices[day];
        }else{
            p2 = backtrack(prices,day+1,-1,transaction+1,k)+prices[day];
        }
        return Math.max(p1,p2);

    }

     private int topDownDP(int [] prices,int day,int buy,int transaction,int k){

        if(day >= prices.length || transaction >=k) return 0;

        int p1= 0, p2 =0;
        int status = buy == -1 ? 0 : 1;

        if(dp[day][status][transaction]!=Integer.MIN_VALUE) return dp[day][status][transaction]; 

        p1 = topDownDP(prices,day+1,buy,transaction,k);//skip
        
        if(buy == -1){
            p2 = topDownDP(prices,day+1,prices[day],transaction,k)-prices[day];//buy
        }else{
            p2 = topDownDP(prices,day+1,-1,transaction+1,k)+prices[day];//sell
        }
        return dp[day][status][transaction] = Math.max(p1,p2);

    }
}