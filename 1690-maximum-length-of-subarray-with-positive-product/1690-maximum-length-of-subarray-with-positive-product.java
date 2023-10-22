class Solution {
    public int getMaxLen(int[] nums) {

        int maxLen = 0;
        int nonZero = 0;
        int start = 0;
        int end = 0 ;
        int negative = 0;
        int leftMostNeg = 10000000, rightMostNeg = 0;
        for(int i = 0; i < nums.length ; i++){
            if(nums[i] != 0){
                if(nums[i] < 0) {
                    if(i < leftMostNeg) leftMostNeg = i;
                    if(i > rightMostNeg) rightMostNeg = i;
                    negative++;
                }
                end = i;
                nonZero = 1;
            }
            if(nums[i]==0 || i == nums.length-1){
                if(negative%2 >0){
                    if(end - rightMostNeg > leftMostNeg-start) maxLen = Math.max(maxLen,end - leftMostNeg);
                    else maxLen = Math.max(maxLen, rightMostNeg-start);
                }
                if(negative%2==0 && nonZero > 0) maxLen = Math.max(maxLen,end-start+1);
                // maxLen = Math.max(maxLen,end-start+1);
                if(nums[i] == 0){
                    start = i+1;
                    end = i+1;
                    leftMostNeg = 10000000;
                    rightMostNeg = start;
                    negative = 0;
                }  
              
            }
            
        }
        return maxLen;
    }
}