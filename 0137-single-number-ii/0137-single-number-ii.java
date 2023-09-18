class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;

        for(int i = 31 ; i >= 0 ;i--){
            int bits = 0;
            for(int j = 0;j < nums.length;j++){
                bits+= (nums[j] >>i) & 1;
                //nums[j] = nums[j] >>1;
            }
            res = (res <<1) + (bits%3);
            bits = 0;
        }
        return res;
    }
}