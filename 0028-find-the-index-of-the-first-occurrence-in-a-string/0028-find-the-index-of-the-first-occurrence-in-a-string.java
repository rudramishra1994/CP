class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;
        int start = 0;
        int left = 0;
        int left1 = 0;
        while(left < haystack.length()){
            if(left1 == needle.length()) return start;
            if(haystack.charAt(left) == needle.charAt(left1)){
                left++;
                left1++;
                
            }else{
                left = start +1;
                start = left;
                left1 = 0;
            }

            if(left1 == needle.length()) return start;
            

        }

        return -1;

    }
}