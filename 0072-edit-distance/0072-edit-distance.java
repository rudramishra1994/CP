

/**
    Pure recursion gives TLE as usual
 */
class Solution {
    public int minDistance(String word1, String word2) {
        //return findDistance(word1,word2,word1.length()-1,word2.length()-1);
        int n = word1.length();
        int m = word2.length();
        if(n==0) return m;
        if(m==0) return n;

        int [][] dp = new int [n+1][m+1];
        for(int i = 1 ; i <=m;i++) dp[0][i] = i;
        for(int i = 1 ; i <=n;i++) dp[i][0] = i;


        for(int i= 1; i <=n ; i++){
            for(int j = 1 ; j <=m ; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(1+dp[i-1][j-1],Math.min(1+dp[i][j-1],1+dp[i-1][j]));
            }
        }
        return dp[n][m];
   }

    private int findDistance(String word1,String word2,int index1, int index2) {
        if(index1 < 0 && index2 >=0) return 1+findDistance(word1,word2,index1,index2-1);
        if(index1 >=0 && index2 < 0) return 1+findDistance(word1,word2,index1-1,index2);
        if(index1 < 0 && index2 < 0) return 0;
        if(word1.charAt(index1) == word2.charAt(index2)) return findDistance(word1,word2,index1-1,index2-1);
        return Math.min(1+findDistance(word1,word2,index1-1,index2-1),
                Math.min(1+findDistance(word1,word2,index1,index2-1), 1 + findDistance(word1,word2,index1-1,index2)));

    }
}