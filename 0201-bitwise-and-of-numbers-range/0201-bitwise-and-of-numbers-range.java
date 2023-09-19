class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int bitsShift = 0;
        while(left < right){
            left>>=1;
            right>>=1;
            bitsShift++;
        }
        return left <<bitsShift;
        
    }
}