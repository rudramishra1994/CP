class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(m < n) return false;
        int sPos = 0,tPos = 0;
        while(sPos < n && tPos < m){
            if(s.charAt(sPos) == t.charAt(tPos)){
                sPos++;
                tPos++;
            }else{
                tPos++;
            }
        }
        return sPos == n ? true : false;

    }
}