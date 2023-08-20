class Solution {
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();
        while(!s.contains(n)){
            s.add(n);
            int sum = 0;
            while(n > 0){
                int digit = n % 10;
                n = n/10;
                sum = sum + digit*digit;
            }
            if(sum == 1) return true;
            n = sum;
        }

        return false;
    }
}