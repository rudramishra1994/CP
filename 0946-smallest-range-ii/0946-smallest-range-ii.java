class Solution {
    public int smallestRangeII(int[] nums, int k) {
       int highest = 0, lowest = 0,gap = Integer.MAX_VALUE; int n = nums.length;
       Arrays.sort(nums);
       gap = nums[n-1] - nums[0];
       for(int i =0; i< nums.length-1 ; i++){
           int a = nums[i], b = nums[i+1];
           highest = Math.max(nums[n-1]-k,nums[i]+k);
           lowest = Math.min(nums[0]+k, b-k);
           gap = Math.min(gap,highest-lowest);
       }
       return gap; 
    }
}