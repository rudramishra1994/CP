class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int [] ans = new int[n];
        for(int i = 0; i < n ; i++){
            int l = 0,r = m-1;
            int mid = 0;
            long minPotion = (long)Math.ceil((1.0*success)/spells[i]);
            if(minPotion > potions[m-1]){
                ans[i] = 0;
                continue;
            }
            while(l <=r){
                mid = l + (r-l)/2;
                if(potions[mid] >= minPotion){
                    r = mid-1;
                }else{
                    l= mid+1;
                }
            }
            ans[i] = m-l;
        }
        return ans;
    }
}