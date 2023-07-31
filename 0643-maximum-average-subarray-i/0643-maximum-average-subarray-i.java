class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int [] sum = new int [n];
        for(int i = 0 ; i < n ;i++){
            if(i==0) sum[i] = nums[i];
            else sum[i] =sum[i-1]+nums[i];
        }
        double maxAvg = (1.0 * sum[k-1])/k;
        for(int i = 1; i <= n-k;i++){
            double currAvg = (1.0 *(sum[k-1+i]-sum[i-1]))/k;
            maxAvg = Math.max(maxAvg,currAvg);
        }
        return maxAvg;

    }
}