class Solution {
    public double myPow(double x, long n) {
        if(n == 0) return 1;
        if(x == 0 || x ==1) return x;
        boolean isNegative = false;
        if( n < 0) isNegative = true;
        double d = 1.0;
        n = Math.abs(n);
        while(n!=0){
            if(n%2!=0) {
                d = d * x;n--;
            }
            x *=x;
            n /=2;

        }
        return isNegative? 1/d : d;
    }
}