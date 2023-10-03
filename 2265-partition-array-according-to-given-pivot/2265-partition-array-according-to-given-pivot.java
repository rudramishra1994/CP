class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int [] ans = new int [nums.length];
        int left = 0, right = nums.length-1;
        for(int i = 0 ; i < nums.length ;i++){
            if(nums[i] < pivot) ans[left++] = nums[i];
            if(nums[nums.length-1-i] >pivot) ans[right--] = nums[nums.length-i-1];
        }
        while(left <= right){
            ans[left++] = pivot;
            ans[right--] = pivot;
        }

        return ans;
    }
}