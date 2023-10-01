class Solution {
    public int romanToInt(String s) {
       int left = 0, n = s.length()-1;
       int [] dec = new int [26];
       dec['I'-'A'] = 1;
       dec['V'-'A'] = 5;
       dec['X'-'A'] = 10;
       dec['L'-'A'] = 50;
       dec['C'-'A'] = 100;
       dec['D'-'A'] = 500;
       dec['M'-'A'] = 1000;
       int res = 0;
       while(left <=n){
            char ch = s.charAt(left);
            if(left == n) return res + dec[ch-'A'];
            char next = s.charAt(left+1);
            if(dec[ch-'A'] < dec[next-'A']) {
                res+=dec[next-'A'] - dec[ch-'A'];
                left = left+2;
                
            }else {
                res+=dec[ch-'A'];
                left++;
            }    
       }
       return res;
    }
}