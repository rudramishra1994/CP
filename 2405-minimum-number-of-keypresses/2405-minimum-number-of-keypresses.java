class Solution {
    public int minimumKeypresses(String s) {
        PriorityQueue<Pair<Character,Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
        int [] alphabets = new int [26];
        for(char c : s.toCharArray()){
            alphabets[c-'a']++;
        }
        int i = 0;
        for(int freq : alphabets){
            if(freq > 0)
                pq.add(new Pair((char)i+97,freq));
                i++;
        }
        int count = 0;
        for(i = 1 ; i <=3 && !pq.isEmpty() ;i++){
            for(int j = 1 ; j <=9 && !pq.isEmpty() ;j++){
                count+=i * pq.poll().getValue();
            }
        }
        return count;
    }
}