class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < nums.length-1 ;i+=2){
            for(int j = 0; j < nums[i];j++){
                ans.add(nums[i+1]);
            }
        }
        int [] res = new int [ans.size()];
        int k = 0;
        for(int val : ans) res[k++] = val;
        return res;

    }
}