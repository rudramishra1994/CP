class Solution {
    public int removeDuplicates(int[] nums) {
        int pos = 0,counter=1;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i]==nums[pos] && counter <2){
                counter++;
                nums[pos+counter-1] = nums[pos];
            }else if(nums[i]!=nums[pos]){
                pos = pos+counter;
                nums[pos] = nums[i];
                counter = 1;
            }
        }
        return pos+counter;
    }
}