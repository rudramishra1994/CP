class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<Integer,List<String>> mp  = new HashMap<>();
        //Map<int [],List<String>> mp  = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(String str : strs){
            int[] map = new int[26];
            for(char ch : str.toCharArray()){
                map[ch-'a'] = map[ch-'a']+1;
            }
            int hashCode = Arrays.hashCode(map);
            if(mp.containsKey(hashCode)) {
                List<String> val = mp.get(hashCode);
                val.add(str);
            }else{
                List<String> val = new ArrayList<>();
                val.add(str);
                mp.put(hashCode,val);
            }
        }

        for(List<String> list : mp.values()) res.add(list);
        return res;
        
    }
}