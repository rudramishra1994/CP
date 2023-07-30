class Solution {
    public int largestAltitude(int[] gain) {
        int currAlt = 0;
        int maxAlt = 0;
        for(int g : gain){
            currAlt+=g;
            maxAlt = Math.max(maxAlt,currAlt);
        }
        return maxAlt;
    }
}