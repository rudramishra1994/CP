class Solution {
    public int maxProfit(int[] prices) {
    int minVal = prices[0];
    int totalProfit = 0;
    for(int i = 1; i < prices.length ;i++){
        if(prices[i] > minVal) 
            totalProfit += prices[i] - minVal;
        minVal = prices[i];
    }
    return totalProfit;

}
}