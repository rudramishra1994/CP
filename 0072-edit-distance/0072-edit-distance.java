class Solution {

    int [][] dp;
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0) return word2.length();
        if(word2.length() == 0) return word1.length();
        dp = new int [word1.length()+1][word2.length()+1];
        //for(int [] row : dp) Arrays.fill(row,-1);
        //return backtrack(0,0,word1,word2);
        //return topDownDp(0,0,word1,word2);

        return bottomUpDp(word1,word2);
    }

    public int topDownDp(int w1, int w2,String word1,String word2){
        if(w2 >=word2.length()) return word1.length() - w1;
        if(w1 >=word1.length()) return word2.length() - w2;
        if(dp[w1][w2] !=-1) return dp[w1][w2];
        if(word1.charAt(w1) == word2.charAt(w2)) return dp[w1][w2] =  topDownDp(w1+1,w2+1,word1,word2);
        else {
            int replace = 1 + topDownDp(w1+1,w2+1,word1,word2);
            int delete = 1 + topDownDp(w1+1,w2,word1,word2);
            int insert = 1 + topDownDp(w1,w2+1,word1,word2);

            return dp[w1][w2] = Math.min(replace,Math.min(delete,insert));
        }
    }

    public int backtrack(int w1, int w2,String word1,String word2){
        if(w2 >=word2.length()) return word1.length() - w1;
        if(w1 >=word1.length()) return word2.length() - w2;
        if(word1.charAt(w1) == word2.charAt(w2))  return backtrack(w1+1,w2+1,word1,word2);
        else {
            int replace = 1 + backtrack(w1+1,w2+1,word1,word2);
            int delete = 1 + backtrack(w1+1,w2,word1,word2);
            int insert = 1 + backtrack(w1,w2+1,word1,word2);

            return Math.min(replace,Math.min(delete,insert));
        }
    }


    public int bottomUpDp(String word1,String word2){
        for(int i = 0 ; i <= word1.length() ;i++) dp[i][0] = i;
        for(int i = 0 ; i <= word2.length() ;i++) dp[0][i] = i;
        for(int i = 1 ; i <=word1.length();i++){
            for(int j = 1 ; j <=word2.length() ; j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = 1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
            }
        }
        return dp[word1.length()][word2.length()];
    }
}