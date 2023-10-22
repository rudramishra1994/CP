class Solution {
    /** Greedy approach */
    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for(char ch : s.toCharArray()){
            if(set.contains(ch)){
                count++;
                set = new HashSet<>();
            }
            set.add(ch);
        }
        if(!set.isEmpty()) count ++;
        return count;
    }
}