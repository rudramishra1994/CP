class Solution {
    public int lengthOfLastWord(String s) {
        String k = s.trim();
        String [] words = s.split(" ");
        return words[words.length-1].length();
    }
}