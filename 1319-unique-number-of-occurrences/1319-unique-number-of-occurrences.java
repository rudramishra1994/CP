class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i : arr) {
            if(!mp.containsKey(i)) mp.put(i,1);
            else {
                int val = mp.get(i);
                mp.put(i,val+1);
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i : mp.values()) {
            if(set.contains(i)) return false;
            set.add(i);
        }

        return true;

    }
}