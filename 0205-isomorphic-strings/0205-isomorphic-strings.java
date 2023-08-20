class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length()!=t.length()) return false;
        Map<Character,Character> mp = new HashMap<>();
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            char currChar = s.charAt(i);
            if(!mp.containsKey(currChar)) {
                    if(mp.containsValue(t.charAt(i))) return false;
                    else mp.put(currChar,t.charAt(i));
            }else if (mp.containsKey(currChar)){
               if(mp.get(currChar) != t.charAt(i)) return false;
            }

        }
        return true;
    }
}