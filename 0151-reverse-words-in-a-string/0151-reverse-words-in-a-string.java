class Solution {
    public String reverseWords(String s) {
        String [] words = s.trim().split(" ");
        StringBuffer br = new StringBuffer();
        for(int i = words.length-1; i >=0 ;i--){
            String word = words[i];
            if (!word.isBlank()) br.append(word).append(" ");
        }

        return br.toString().trim();
    }
}