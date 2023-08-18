class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> seen = new HashMap<>();
        int left = 0;
        int maxSubString = 0;
        for(int i = 0 ; i < s.length() ; i++){
           if(seen.containsKey(s.charAt(i))){
                int index = seen.get(s.charAt(i));
                if(index >=left) left = index +1;
           }
           maxSubString = Math.max(maxSubString,i-left+1);
           seen.put(s.charAt(i),i);
        }

        return maxSubString;
    }
}