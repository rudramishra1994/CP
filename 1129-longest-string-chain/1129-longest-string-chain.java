class Solution {
    Map<String,Integer> dp = new HashMap<>();
    public int longestStrChain(String[] words) {
        if(words.length < 2) return words.length;
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        int maxOverAll = 1;
        for(String word : words){
            //maxOverAll = Math.max(maxOverAll,solveBruteForce(word,wordSet));
            maxOverAll = Math.max(maxOverAll,solveTopfDown(word,wordSet));
        }
        return maxOverAll;
    }

    public int solveTopfDown (String word ,Set<String> wordSet){
        if(word.length() == 0 || !wordSet.contains(word)) return 0;
        if(dp.containsKey(word)) return dp.get(word);
        int maxVal = 1;
        for(int i = 0 ; i < word.length() ; i++){
            String substring = word.substring(0,i) + word.substring(i+1);
            maxVal = Math.max(maxVal, 1 + solveTopfDown(substring,wordSet));
        }
        dp.put(word,maxVal);
        return maxVal;
    }


    public int solveBruteForce(String word ,Set<String> wordSet){
        if(word.length() == 0 || !wordSet.contains(word)) return 0;
        int maxVal = 1;
        for(int i = 0 ; i < word.length() ; i++){
            String substring = word.substring(0,i) + word.substring(i+1);
            maxVal = Math.max(maxVal, 1 + solveBruteForce(substring,wordSet));
        }
        return maxVal;
    }
}