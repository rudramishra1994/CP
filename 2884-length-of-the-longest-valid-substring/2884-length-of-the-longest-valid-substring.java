class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> forbiddenWords = new HashSet<>();
        Set<Character> endChar = new HashSet<>();
        for(String fdn :forbidden) {
            forbiddenWords.add(fdn);
            endChar.add(fdn.charAt(fdn.length()-1));
        }
        int i = 0;
        int max  = 0;
        int start = 0;
        int n = word.length();
        while(i < n){
           
                for(int j = i ; j > i-10 && j >=start;j--){
                    if(forbiddenWords.contains(word.substring(j,i+1))){
                        start = j+1;
                        break;
                    }
                }
                max = Math.max(max,i-start+1);
            
            i++;
        }
        return max;

    }
}