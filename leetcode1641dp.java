public class Solution {
    public int countVowelStrings(int n) {
        int [][]dp = new int [n][5];
        dp[0] = Arrays.copyOf(new int[]{1,2,3,4,5},5);
        for(int i = 1 ; i< n ;i++){
            dp[i][0] = 1;
            for(int j  = 1 ; j< 5;j++){
                dp[i][j] = dp [i][j-1] + dp [i-1][j]; 
            }
        }
        return dp[n-1][4];
    }
}