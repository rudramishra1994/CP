class Solution {
    int dp[][];
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int minTillNow = prices[0];
        for(int price : prices){
            if(minTillNow > price) minTillNow = price;
            if(maxProfit < price - minTillNow)
            maxProfit = price-minTillNow;
        }
        return maxProfit;
       
    }    
}