class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0;
        int minLen = nums.length,sum = 0,sum2 = 0;
        while(r < nums.length){
            sum  += nums[r];
            sum2 += nums[r];
            if(sum >=target) {
                while(sum >=target){
                    minLen = Math.min(minLen,r - l + 1);
                    l++;
                    sum -=nums[l-1];
                }    
            }
            r++;
        }
        if(minLen==nums.length && sum2 <target) return 0;
        return minLen;
    }
}