class Solution {
    public long getDescentPeriods(int[] prices) {
        long count = 1;long sum = 0;
        int n= prices.length;
        for(int right = 0; right < n;right++)
        {
            if(right > 0){
                if(prices[right-1] - prices[right] == 1) count++;
                else{
                    sum += count*(count+1)/2;
                    count = 1 ;
                }
            }
        }
        return sum +count*(count+1)/2;
    }
}