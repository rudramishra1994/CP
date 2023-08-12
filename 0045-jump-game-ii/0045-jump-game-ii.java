

//can be done using dp. But greedy is the best approach.
class Solution {
    public int jump(int[] nums) {
        int left = 0,right =0 ,res = 0;
        while(right < nums.length - 1){
            int farthest = 0;
            for(int i = left; i <=right;i++){
                farthest = Math.max(farthest,i+nums[i]);
            }
            left = right+1;
            right = farthest;
            res++;
        }
        return res;
    }
}