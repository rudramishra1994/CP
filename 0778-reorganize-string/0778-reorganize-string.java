class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<Pair<Character,Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        char [] ch = s.toCharArray();
        int [] freq = new int [26];
        for(char c : ch){
            freq[c-'a']++;
        }
        for(int i = 0 ; i < 26 ;i++){
            if(freq[i] > 0){
                char c = (char) (i+'a');
                maxHeap.add(new Pair<>(c,freq[i]));
            }
        }
        
        StringBuilder br = new StringBuilder();
        while(!maxHeap.isEmpty()){
            Pair<Character,Integer> pair = maxHeap.poll();
            char c = pair.getKey();
            int count = pair.getValue();
            if((br.length() > 0 && c!=br.charAt(br.length()-1)) || br.isEmpty()){
                br.append(c);
                count--;
                
            }else{
                if(maxHeap.isEmpty()) return "";
                Pair<Character,Integer> pair2 = maxHeap.poll();

                char c2 = pair2.getKey();
                int count2 = pair2.getValue();
                br.append(c2);count2--;
                if(count2 > 0) maxHeap.add(new Pair<>(c2,count2));
            }
            if(count > 0) maxHeap.add(new Pair<>(c,count));
        }
        return br.toString();
       
        
    }
}