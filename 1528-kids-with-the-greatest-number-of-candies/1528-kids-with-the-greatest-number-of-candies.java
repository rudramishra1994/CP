class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = 0;
        for(int i : candies) maxCandy = maxCandy < i ? i : maxCandy;
        List<Boolean> res = new ArrayList<>();
        for(int i : candies){
            if((maxCandy-i) <= extraCandies) res.add(true);
            else res.add(false);
        }

        return res;

    }
}