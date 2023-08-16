class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) return false;
        int tStart = 0,sStart = 0;
        while(tStart < t.length() && sStart < s.length()){
            if(t.charAt(tStart) == s.charAt(sStart)) {
                sStart++;
            }
            tStart++;
        }
        return sStart == s.length();
    }
}