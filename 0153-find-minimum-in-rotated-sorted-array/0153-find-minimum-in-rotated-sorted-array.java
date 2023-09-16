class Solution {
    public int findMin(int[] nums) {
        return nums[findPivot(nums)];
    }

    private int findPivot(int [] nums){
        int l = 0 , r = nums.length-1,n = nums.length-1;
        while(l <=r){
            int mid = l+(r-l)/2;
            if(nums[mid] > nums[n]) l = mid +1;
            else r = mid -1;
        }
        return l;
    }
}