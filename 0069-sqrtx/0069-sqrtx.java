class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        long l = 2 , r= x/2;
        while(l <= r){
            long m = l + (r-l)/2;
            if( m * m > x) r=  m -1;
            else if(m * m < x) l = m +1;
            else return (int) m;
        }
        return (int)r;
    }
}