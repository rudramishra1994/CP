class Solution {
    public int majorityElement(int[] nums) {
        int count = 0,candidate = nums[0];
        for(int i : nums){
            if(count == 0){
                candidate = i;
            }
            count += candidate==i ?1:-1;
        }
        return candidate;
    }
}