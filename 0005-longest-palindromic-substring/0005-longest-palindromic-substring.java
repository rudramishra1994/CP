class Solution {
    StringBuilder br = new StringBuilder();
    public String longestPalindrome(String s) {
        if(s.length() < 2) return s;
        int maxLen = 1;int left = 0,right = left+1;
        for(int i = 0 ; i < s.length() ;i++){
            int l =i, r= i,len =1;
            while(l >=0 && r <=s.length()-1)
            {
                if(s.charAt(l) != s.charAt(r)){
                   break;
                }
                len = r-l+1;r++;l--;
            }
            if(maxLen < len) {
                maxLen = len;
                left = l+1;
                right = r;
            }

            l = i; r= i+1;len =1;
            while(l >=0 && r <=s.length()-1){
                if(s.charAt(l) != s.charAt(r)){
                   break;
                }
                len = r-l+1;r++;l--;
            }
            if(maxLen < len) {
                maxLen = len;
                left = l+1;
                right = r;
            }
        }


        return s.substring(left,right);

    }
}