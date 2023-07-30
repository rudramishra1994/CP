class Solution {
    public int pivotIndex(int[] nums) {
        int [] runSum = new int [nums.length];
        runSum[0] = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            runSum[i] =runSum[i-1] +  nums[i];
        }
        int leftSum = 0, rightSum = 0, n= nums.length;;
        for(int i = 0; i< n ; i++){
            leftSum = i == 0 ? 0 : runSum[i-1];
            rightSum = i == (n-1) ? 0 : runSum[n-1]-runSum[i];
            if(leftSum == rightSum) return i; 
        }
        return -1;
    }
}