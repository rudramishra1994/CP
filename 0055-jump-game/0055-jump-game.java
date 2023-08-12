class Solution {
    boolean [] dp;
    public boolean canJump(int[] nums) {
        int currGoal = nums.length - 1;
        int n = nums.length - 1; 
        for(int i = n - 1; i >= 0 ;i--){
            if(i+nums[i] >=currGoal) currGoal = i;
        } 

        return currGoal == 0;
    }
    
}