class Solution {
    public String firstPalindrome(String[] words) {
        for(String s : words){
            int n = s.length();
            int i = 0;
            boolean flag = true;
            for(i = 0 ; i < n/2 ; i++){
                if(s.charAt(i) != s.charAt(n-1-i)) {
                    flag = false;
                    break;
                }
            }
            if(flag) return s;
        }
        return "";
    }
}