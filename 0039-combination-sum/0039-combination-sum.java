class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(candidates,target,0,new ArrayList<>(),combinations);
        return combinations;

    }

    private void backtrack(int [] candidates,int target,int start,List<Integer> combination, List<List<Integer>>combinations){
        if(target < 0) return;
        if(start >=candidates.length) return;
        if(target ==0){
            combinations.add(new ArrayList<>(combination));
            return;
        }
        combination.add(candidates[start]);
        backtrack(candidates,target-candidates[start],start,combination,combinations);
        combination.remove(combination.size()-1);
        backtrack(candidates,target,start+1,combination,combinations);
    }
}