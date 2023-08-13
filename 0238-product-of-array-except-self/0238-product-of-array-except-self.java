

/* The most basic solution T : O(n); Try finding a solution with S : O(1) */
class Solution {
    // public int[] productExceptSelf(int[] nums) {
    //     int n = nums.length;
    //     int [] prefix = new int [n];
    //     int [] suffix = new int [n];
    //     prefix[0] = nums[0];
    //     suffix[n-1] = nums[n-1];

    //     for(int i = 1 ; i <=n-1;i++){
    //         prefix[i] = nums[i]*prefix[i-1];
    //         suffix[n-1-i] =nums[n-1-i]*suffix[n-i];
    //     }
    //     nums[0] = suffix[1];
    //     nums[n-1] = prefix[n-2];
    //     for(int i = 1; i <=n-2;i++){
    //        nums[i] = prefix[i-1] * suffix[i+1];
    //     }

    //     return nums;
    // }



    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] prefix = new int [n];
        prefix[0] =1;
        for(int i = 1 ;i < n;i++){
            prefix[i] = nums[i-1] * prefix[i-1];
        }
        int R =1;
        for(int i = n-1; i >=0;i--){
            prefix[i] = prefix[i] * R;
            R = R*nums[i];
        }
        return prefix;
       
    }




}