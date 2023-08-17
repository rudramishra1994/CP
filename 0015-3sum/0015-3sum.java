class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        for(int first = 0 ; first < nums.length && nums[first] <=0;first++){
            if(first == 0 || nums[first]!=nums[first-1]) solve(nums,first);   
        }
        return ans;
    }
    private void solve(int [] nums, int first){
       
            int r = nums.length-1;
            int l = first+1;
            while(l < r){
                int sum = nums[first]+nums[l]+nums[r];
                if(sum == 0){
                    ans.add( Arrays.asList(nums[first],nums[l++],nums[r--]));
                    while(l < r && nums[l]==nums[l-1])l++;
                    
                }
                else if(sum > 0) r--;
                else l++;
            }
        
    }
}