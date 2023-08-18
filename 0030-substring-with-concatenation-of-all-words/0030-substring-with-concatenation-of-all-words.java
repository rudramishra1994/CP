class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        Map<String, Integer> freq = new HashMap<>();
        Set<Integer> ans = new HashSet<>();
        for(String word : words) freq.put(word,freq.getOrDefault(word,0)+1);
        int windowSize = words.length * words[0].length();
        if(s.length() < windowSize) return new ArrayList<>();
        int n = s.length();
        int wordSize = words[0].length();
        for(int k = 0 ; k < wordSize;k++){
            int l = k , r = k;
            int wordCount = 0;
            Map<String, Integer> windowMap = new HashMap<>();
            while(r <= n-wordSize){
                String currWord = s.substring(r,r+wordSize);
                if(!freq.containsKey(currWord)){
                    r+=wordSize;
                    l = r;
                    windowMap = new HashMap<>();
                    wordCount = 0;
                }else{
                    windowMap.put(currWord,windowMap.getOrDefault(currWord,0)+1);
                    r = r + wordSize;
                    wordCount++;
                    while(windowMap.get(currWord)>freq.get(currWord)){
                        String wordToRemove = s.substring(l,l+wordSize);
                        windowMap.put(wordToRemove,windowMap.get(wordToRemove)-1);
                        l = l + wordSize;
                        wordCount --;
                    }

                    if(wordCount == words.length) ans.add(l);

                }

            }
        }
        return new ArrayList<>(ans);

    }
}