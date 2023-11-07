class Solution {
    int count = 0;
    public long numberOfWays(String s) {
       long n0= 0, n1= 0,n10 = 0 , n01 = 0;long total = 0;
       for(char c : s.toCharArray()){
           if(c == '1'){
               n1++;
               n01+= n0;
               total += n10;
           }else{
               n0++;
               n10+=n1;
               total+=n01;
           }
       }
       return total;
    }
}
