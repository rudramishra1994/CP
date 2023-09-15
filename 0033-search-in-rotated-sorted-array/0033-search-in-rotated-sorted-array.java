class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int pivot = findPivot(nums);
        int ans = findTargetIndex(nums,0,pivot-1,target);
        if (ans ==-1) return findTargetIndex(nums,pivot,r,target);
        return ans;

    }
    private int findTargetIndex(int [] nums ,int l,int r,int target){
        while(l < r){
            int mid = l + (r-l)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid+1;
            else r = mid -1; 
        }
        return nums[l]== target?l:-1;
    }

    private int findPivot(int [] nums){
        int l = 0 ,r = nums.length-1;
        while(l <=r){
            int mid = l + (r-l)/2;
            if (nums[mid] > nums[nums.length-1]) l = mid+1;
            else r = mid -1; 
        }
        return l;
    }
}