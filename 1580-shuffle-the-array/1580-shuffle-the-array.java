class Solution {
    public int[] shuffle(int[] nums, int n) {
        int [] ans = new int [2*n];
        int count = 1;
        int j = 0;
        for(int i = 0 ; i < 2*n-1 ; i+=2,j++){
            ans[i] = nums[j];
            ans[i+1] = nums[n+j];
        }
        return ans;
    }
}