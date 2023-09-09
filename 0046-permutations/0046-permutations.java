class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        boolean [] seen = new boolean[nums.length];
        backtrack(nums,seen,0,new ArrayList<>(),res);
        return res;
        
    }

    private void backtrack(int [] nums,boolean [] seen,int  pos, List<Integer> permutation,List<List<Integer>> permutations){
        if(pos ==nums.length){
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        for(int i = 0 ; i <nums.length;i++){
            if(!seen[i]){
                permutation.add(nums[i]);
                seen[i] = true;
                backtrack(nums,seen,pos+1,permutation,permutations);
                permutation.remove(pos);
                seen[i] = false;
            }
        }
    }
}