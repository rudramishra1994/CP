class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum ,minSum ,currMin,currMax,totalSum;
        maxSum = minSum = totalSum = currMin = currMax = nums[0];
        for(int i = 1 ; i < nums.length;i++){
            currMax = Math.max(currMax+nums[i],nums[i]);
            maxSum = Math.max(maxSum,currMax);
            currMin = Math.min(currMin+nums[i],nums[i]);
            minSum = Math.min(minSum,currMin);
            totalSum+=nums[i];
        }

        if(minSum == totalSum) return maxSum;
        return Math.max (maxSum,totalSum-minSum);
    }
}