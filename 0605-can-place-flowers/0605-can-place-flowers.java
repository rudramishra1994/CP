class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        if(n==0 || (m==1 && n<=1 && flowerbed[0]==0)) return true;
        for(int i = 0; i < m && n > 0; i++ ){

            if(flowerbed[i] ==0){
                if((i == 0  && flowerbed[i+1]==0) || (i == m-1 && flowerbed[i-1]==0)
                        ||(i > 0 && i < m-1 && flowerbed[i-1] == 0 && flowerbed[i+1]==0)) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
           
            
        }
        return n == 0 ? true: false;
    }
}