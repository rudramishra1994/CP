class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        Map<Character,Integer> s_freq = new HashMap<>();
        Map<Character,Integer> t_freq = new HashMap<>();
        String minStr = "";int minStrLen = s.length();
        int windowLen = 0;

        for(char c : t.toCharArray()){
            t_freq.put(c,t_freq.getOrDefault(c,0)+1);
        }

        int left = 0, start = 0, right = s.length()-1;

        while(left <=right){
            char c = s.charAt(left);
            if(t_freq.containsKey(c)) {
                int count = s_freq.getOrDefault(c,0);
                s_freq.put(c,count+1);
                windowLen++;
            }
            if(windowLen >=t.length()){ 
                while(windowLen >=t.length() && isWindowValid(s_freq,t_freq)){
                    if(minStrLen >= left-start+1){
                        minStrLen = left - start +1;
                        minStr = s.substring(start,left+1);
                        if(minStrLen == t.length()) return minStr;
                    }
                    char ch = s.charAt(start++);
                    if(s_freq.containsKey(ch)){
                        int count  = s_freq.get(ch);
                        s_freq.put(ch,count-1);
                        windowLen--;
                        if(s_freq.get(ch)==0) s_freq.remove(ch);
                    }
                }
                
            }
            left++;
        }
        return minStr;

    }

    private boolean isWindowValid(Map<Character,Integer> s_freq , Map<Character,Integer> t_freq){
        
        for(char c : t_freq.keySet()){
            if( !(s_freq.containsKey(c) && t_freq.get(c) <=s_freq.get(c))) return false;
        }
        return true;
    }
} 