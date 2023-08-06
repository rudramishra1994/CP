
/**

    Recursion with no memoization gives TLE as usual.

 */
// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         return LCS(text1.toCharArray(),text2.toCharArray(),0,0);
//     }
//     private int LCS(char [] text1,char [] text2,int index1,int index2){
//         if(index1 > text1.length-1 || index2 > text2.length-1) return 0;
//         if(text1[index1] == text2[index2]) return 1 + LCS(text1,text2,index1+1,index2+1);
//         return Math.max(LCS(text1,text2,index1+1,index2),LCS(text1,text2,index1,index2+1));
//     }
// }

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int [][] dp = new int [text1.length()+1][text2.length()+1];
        for(int i = 1; i < text1.length()+1 ; i++){
            for(int j = 1 ; j < text2.length()+1 ; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]); 
            }
        }
        return dp[text1.length()][text2.length()];

    }
    private int LCS(char [] text1,char [] text2,int index1,int index2){
        if(index1 > text1.length-1 || index2 > text2.length-1) return 0;
        if(text1[index1] == text2[index2]) return 1 + LCS(text1,text2,index1+1,index2+1);
        return Math.max(LCS(text1,text2,index1+1,index2),LCS(text1,text2,index1,index2+1));
    }
}


