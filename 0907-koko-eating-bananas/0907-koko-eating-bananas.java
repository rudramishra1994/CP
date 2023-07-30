class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = Integer.MIN_VALUE;
        for(int pile : piles){
            if(pile > maxPile) maxPile = pile;
        }
        int l = 1,r = maxPile;
        while(l <=r){
            int mid = l+(r-l)/2;
            if(numberOfHours(piles,mid)>h) l = mid+1;
            else r = mid-1;
        }
        return l;


    }

    private long numberOfHours(int [] piles, int k){
        long hours = 0;
        for(int pile : piles){
            hours += (int)Math.ceil((1.0*pile)/k);
        }
        return hours;
    }
}