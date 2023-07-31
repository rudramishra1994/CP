class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if(n==1) return;
        int l = 0,r =1 ;
        while(r < n){
            if(nums[l] == 0 && nums[r]!=0){
                nums[l] = nums[r];
                nums[r] = 0;
                l++;
                r++;
            }else if (nums[l]!=0 && nums[r]==0){
                l++;
                r++;
            }else if (nums[l]!=0 && nums[r]!=0){
                l++;
                r++;
            }else if (nums[l]==0 && nums[r]==0){
                r++;
            }
        }
       
    }
}