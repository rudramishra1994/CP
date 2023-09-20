class Solution {
    public int climbStairs(int n) {
        if( n <3) return n;
        int [] dp = new int [n+1];
        int x = 1 ;
        int y  = 2 ;
        int z = 0;
        for(int i = 3 ; i < n+1 ; i++) {
            z = x + y;
            x = y;
            y = z;

        }
        return z;
    }
}