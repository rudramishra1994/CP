public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        List<Integer> bits = new ArrayList<>();
        int res = 0;
        int k = 31;
        for(int i = 0; i < 32;i++){
            res = (res << 1)|(n &1);
            n = n>>1;
        }
    return res;
    }
}