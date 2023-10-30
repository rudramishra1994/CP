class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int [] candleToLeft = new int [n];
        int [] candleToRight = new int [n];
        int [] ncandles = new int [n];
        Arrays.fill(candleToLeft,-1);
        Arrays.fill(candleToRight,999999);
        Arrays.fill(ncandles,0);
        int [] ans = new int [queries.length];
        for(int i =0 ;i < n ;i++){
            if(s.charAt(i) =='|') candleToLeft[i] = i;
            else if(i > 0 && s.charAt(i)=='*') candleToLeft[i] = candleToLeft[i-1];

            if(s.charAt(n-1-i) =='|') candleToRight[n-1-i] = n-1-i;
            else if(n-1-i < n-1 && s.charAt(n-1-i)== '*') candleToRight[n-1-i] = candleToRight[n-i];

            if(s.charAt(i) == '|'){
                if(i==0) ncandles[i] =1;
                else ncandles[i] = ncandles[i-1]+1;
            }else if(i > 0){
                ncandles[i] = ncandles[i-1];
            } 
        }
        int count = 0;
        for(int []q : queries){
            // find the rightmost candle of the start of the query
            int l = candleToRight[q[0]];
            //find the leftmost candle of the end of the query
            int r = candleToLeft[q[1]];
            //find the candle in between 
            if(l < r){
                int c = ncandles[r]-ncandles[l]-1;
                ans[count] = Math.max(ans[count],r-l-c-1);
            }
            
            count++;
        }





        return ans;
    }
}