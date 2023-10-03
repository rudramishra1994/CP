class Solution {

    /*
        Floyd's cycle detection algorithm'
     */
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0], hare = nums[0];
        do{
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];

        } while(tortoise!=hare);

        hare = nums[0];

        while(tortoise!=hare){
            tortoise = nums[tortoise];
            hare = nums[hare];
        };

        return hare;
    }
}