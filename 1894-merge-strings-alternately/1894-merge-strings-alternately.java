class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = Math.min(word1.length(),word2.length());
        String longerWord = null;
        if(word1.length() != word2.length())
            longerWord = word1.length() > word2.length() ? word1 : word2;
        
        StringBuilder br = new StringBuilder();
        for(int i = 0; i < n ; i++){
            br.append(word1.charAt(i));
            br.append(word2.charAt(i));
        }
        if(longerWord!=null) br.append(longerWord.substring(n));
        return br.toString();
    }
}