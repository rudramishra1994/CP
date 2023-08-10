class Solution {
    public int removeDuplicates(int[] nums) {
        int pos = 0;int k = 0;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i]!=nums[pos]){
                if(i-pos>=2)
                    nums[++pos] = nums[i];
                else pos++;
            }else if(nums[i]==nums[pos])k++;
        }
        return nums.length-k;
    }
}