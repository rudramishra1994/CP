class Solution {
    Boolean [] dp ;
    /**
        1 - true;
        0 - false;
        -1 - not calculated;
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()+1];
        Set<String> dict = new HashSet<>(wordDict);
        //Arrays.fill(dp,null);
        return solve(s,dict,0);
        
    }

    private boolean solve(String s , Set<String>dict,int start){
        if (dict.contains(s)) return true;
        if (s.length() ==start) return true;
        if (dp[start] !=null) return dp[start];
        for(int i = start+ 1; i <= s.length() ;i++){
            if(dict.contains(s.substring(start,i)) && solve(s,dict,i)){
               return dp[start] = true;
            }

        }
        return dp[start] = false;
    }
}