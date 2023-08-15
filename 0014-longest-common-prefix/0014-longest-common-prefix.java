class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minWord = Integer.MAX_VALUE;
        //if (strs.length == 1) return strs[0];
        String minStr = "";
        for(String i : strs){
            if(i.length() < minWord) {
                minWord = Math.min(minWord,i.length());
                minStr = i;
            }
        }
        StringBuffer br = new StringBuffer();
        boolean match = false;
        for(int i = 0 ; i < minWord ; i++){
            for(String str : strs){
                if(str.charAt(i) == minStr.charAt(i)) {
                    match = true;
                }else{
                    match = false;
                    return br.toString();
                }
            }
            if(match) br.append(minStr.charAt(i));
        }
        return br.toString();
    }
}