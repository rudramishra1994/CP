class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int count = 0;
        int pos = n;
        for(int i = 0; i < n ;i++){
            if(nums[i]==val && pos > i){
                pos = i;
            }else if(nums[i]!=val && pos < n){
                nums[pos] = nums[i];
                pos++;
            }

        }
        return pos;
    }
}