class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int l = 0;
        for(int i= 1 ; i < nums.length;i++){
          if(nums[i] - nums[i-1] !=1){
            if(l==i-1) res.add(String.valueOf(nums[l]));
            else res.add(nums[l] + "->"+nums[i-1]);
            l = i;
          }  
        }

        if(l == nums.length-1)res.add(String.valueOf(nums[l]));
        else if (l < nums.length-1)res.add(nums[l] + "->"+nums[nums.length-1]);
        return res;
    }
}