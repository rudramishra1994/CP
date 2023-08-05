class Solution {
    public int[] countBits(int n) {
        int [] ans = new int [n+1];
        for(int i = 1; i < n+1;i++){
            int k = i, count = 0;
            while(k > 0) {
                count += k & 1;
                k = k>>1;
            }
            ans[i] = count;
        }
        return ans;
    }
}