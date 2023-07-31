class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int [] freqArray = new int [2001];
        for(int i : arr) freqArray[i+1000]++;
        Set<Integer> unique  = new HashSet<>();
        for(int i : freqArray){
            if(i > 0 && unique.contains(i)) return false;
            else unique.add(i);
        }
        return true;
    }
}