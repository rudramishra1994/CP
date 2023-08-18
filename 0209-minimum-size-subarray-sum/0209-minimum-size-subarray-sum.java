class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE,sum = 0;
        while(r < nums.length){
            sum  += nums[r];
            while(sum >=target){
                minLen = Math.min(minLen,r - l + 1);
                l++;
                sum -=nums[l-1];
            }    
            r++;
        }
        return minLen < Integer.MAX_VALUE ? minLen: 0;
    }
}