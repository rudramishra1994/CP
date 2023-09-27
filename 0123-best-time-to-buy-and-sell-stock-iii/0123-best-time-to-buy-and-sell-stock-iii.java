class Solution {

    int [][][] dp ;
    public int maxProfit(int[] prices) {
        dp = new int [prices.length][2][3];
        for(int i = 0 ; i < prices.length ;i++){
            for(int j = 0 ; j < 2;j++){
                for(int k = 0 ; k < 3;k++){
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        //return backtrack(prices,0,-1,0);
        return topDownDP(prices,0,-1,0);
        
    }


    private int backtrack(int [] prices,int day,int buy,int transaction){
        if(day >= prices.length || (transaction >=2 && buy ==-1)) return 0;

        int p1= 0, p2 =0;

        p1 = backtrack(prices,day+1,buy,transaction);

        if(buy == -1){
            p2 = backtrack(prices,day+1,prices[day],transaction+1)-prices[day];
        }else{
            p2 = backtrack(prices,day+1,-1,transaction)+prices[day];
        }
        return Math.max(p1,p2);

    }

    private int topDownDP(int [] prices,int day,int buy,int transaction){

        if(day >= prices.length || (transaction >=2 && buy ==-1)) return 0;

        int p1= 0, p2 =0;
        int status = buy == -1 ? 0 : 1;

        if(dp[day][status][transaction]!=Integer.MIN_VALUE) return dp[day][status][transaction]; 

        p1 = topDownDP(prices,day+1,buy,transaction);//skip
        
        if(buy == -1){
            p2 = topDownDP(prices,day+1,prices[day],transaction+1)-prices[day];//buy
        }else{
            p2 = topDownDP(prices,day+1,-1,transaction)+prices[day];//sell
        }
        return dp[day][status][transaction] = Math.max(p1,p2);

    }





    


}