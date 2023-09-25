class Solution {
    String s1,s2,s3;
    Boolean dp[][];
    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;this.s2 =s2;this.s3 = s3;
        if(s1.length() + s2.length() !=s3.length()) return false;
        dp = new Boolean[s1.length()+1][s2.length()+1];
        return backtrack(0,0,0);
    }


    public boolean backtrack(int i ,int j,int k){
        if( i >=s1.length())  return s3.substring(k).equals(s2.substring(j));
        if( j >=s2.length())  return s3.substring(k).equals(s1.substring(i));
        if(dp[i][j]!=null) return dp[i][j];
        return dp[i][j] = (s3.charAt(k) == s1.charAt(i) && backtrack(i+1,j,k+1))
                            ||(s3.charAt(k)==s2.charAt(j) && backtrack(i,j+1,k+1));
    }
}