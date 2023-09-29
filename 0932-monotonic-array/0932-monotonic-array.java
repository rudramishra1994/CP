class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean decreasing = true , increasing = true;
        for(int i = 0 ; i < nums.length-1;i++){
            if(decreasing && nums[i] < nums[i+1]) decreasing = false;
            if(increasing && nums[i] > nums[i+1]) increasing = false;
        }


        return decreasing || increasing;
    }
}