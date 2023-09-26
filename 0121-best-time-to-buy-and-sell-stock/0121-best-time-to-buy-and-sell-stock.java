class Solution {
    int dp[][];
    public int maxProfit(int[] prices) {
        int n = prices.length-1;
        int maxProfit = Integer.MIN_VALUE;
        int minTillNow = prices[0],maxTillNow = prices[n];
        for(int price : prices){
            if(minTillNow > price) minTillNow = price;
            maxProfit = Math.max(maxProfit,price-minTillNow);
        }
        return maxProfit;
       
    }    
}