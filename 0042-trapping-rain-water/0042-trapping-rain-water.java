class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int [] lMax = new int [n];
        int [] rMax = new int [n];
        int max = 0;
        for(int i = 1 ; i < n ; i++){
            if(max < height[i-1]){
                max  = height[i-1];
            }
            lMax[i] = max;
        }   
        max = 0;
         for(int i = n-2 ; i >=0 ; i--){
            if(max < height[i+1]){
                max  = height[i+1];
            }
            rMax[i] = max;
        }
        int totalWater = 0;
        for(int i = 0 ; i < n ; i++){
            int diff = Math.min(lMax[i],rMax[i]) - height[i];
            totalWater += diff > 0 ? diff : 0 ;
        }  
        return totalWater;
    }
}