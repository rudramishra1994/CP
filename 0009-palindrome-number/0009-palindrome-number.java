class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false; 
        if(x < 10) return true;
        int k = x;
        int rev = 0;
        while(k!=0){
            rev = rev *10+k%10;
            k /=10;
        }    
        return x==rev;
    }
}