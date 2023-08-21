class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> res = new ArrayList<>();
        if(nums.length < 1) return res;
        int l = 0;
        for(int i= 1 ; i < nums.length;i++){
            
          if(nums[i] - nums[i-1] !=1){
            StringBuilder br = new StringBuilder();  
            if(l==i-1) res.add(String.valueOf(nums[l]));
            else res.add(br.append(nums[l]).append("->").append(nums[i-1]).toString());
            l = i;
          }  
        }
        StringBuilder br = new StringBuilder();  
        if(l == nums.length-1)res.add(String.valueOf(nums[l]));
        else res.add(br.append(nums[l]).append("->").append(nums[nums.length-1]).toString());
        return res;
    }
}