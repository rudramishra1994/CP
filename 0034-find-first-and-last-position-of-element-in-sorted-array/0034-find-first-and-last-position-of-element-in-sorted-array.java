class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length < 1) return new int[]{-1,-1};
        return new int [] {findIndex(nums,target,true),findIndex(nums,target,false)};
    }

    private int findIndex(int [] nums ,int target, boolean first){
        int l = 0 , r = nums.length-1 , n = nums.length;
        while(l <r){
            int m = l + (r-l)/2;
            if(nums[m] == target) {
                if(!first){
                    if(m+1 < n && nums[m+1]==target) l = m+1;
                    else return m;
                }else{
                    if(m-1 >=0 && nums[m-1]==target) r = m-1;
                    else return m;
                }    
            }else if(nums[m] < target) l = m+1;
            else r = m-1;
        }

        return nums[l] == target ? l : -1;
    }



}