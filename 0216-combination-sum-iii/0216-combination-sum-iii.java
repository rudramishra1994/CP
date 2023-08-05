class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combination =  new ArrayList<>();
        for(int i= 0 ; i < k ; i++){
            combination.add(0);
        }
        int [] nums = new int []{1,2,3,4,5,6,7,8,9};
        findCombination(k-1,n,combinations,combination,nums,0);
        return combinations;    
    }
    private void findCombination(int k, int n, List<List<Integer>> combinations, List<Integer> combination,int [] nums,int pos){
        if(n < 0) return ;
        if(k < 0){
            if(n == 0){
                combinations.add(new ArrayList<>(combination));
                return;
            }else return;
        } 
        for(int i = pos ; i < 9 ; i++){
            combination.set(k,nums[i]);
            findCombination(k-1,n-nums[i],combinations,combination,nums,i+1);
        }
    }
}