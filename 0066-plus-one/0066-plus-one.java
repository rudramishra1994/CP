class Solution {
    public int[] plusOne(int[] digits) {
        int s = digits.length+1;
        int [] res = new int [s];
        int carry = 1;
        int pos = s-1;
        for(int i = digits.length-1;i >=0;i--,pos--){
                int val = digits[i]+carry;
                carry = val/10;
                res[pos] = val %10;
        }
        if(carry == 1) {
            res[0] = 1;
            return res;
        }else {
             return Arrays.copyOfRange(res,1,s);
        }
    }
}