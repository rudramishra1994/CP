class Solution {
    public int hIndex(int[] citations) {
        int [] bucket = new int [1001];
        for(int i : citations) bucket[i]++;
        int h_index = 0;
        if(bucket[1000] >=1000) return 1000;
        for(int i= 999 ; i>=0 ; i--){
            bucket[i]+=bucket[i+1];
            if(bucket[i] >= i && i > h_index) h_index = i;
        }
        return h_index;
    }
}