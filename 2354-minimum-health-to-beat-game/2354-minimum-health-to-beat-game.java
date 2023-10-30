class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long maxDamage = 0;
        long totalDamage = 0;
        for(int n : damage){
            totalDamage+=n;
            maxDamage = Math.max(maxDamage,n);
        }
        return totalDamage+1-Math.min(maxDamage,armor);
    }
}