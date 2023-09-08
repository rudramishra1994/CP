class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtracking(1,n,0,k,new ArrayList<>(),combinations);
        return combinations;
    }

    private void backtracking(int start,int n, int k,int maxK,List<Integer>combination, List<List<Integer>> combinations){
       if(k >=maxK) return;
       for(int i = start;i <=n ; i++) {
           combination.add(i);
           if(k == maxK-1) combinations.add(new ArrayList<>(combination));
           backtracking(i+1,n,k+1,maxK,combination,combinations);
           combination.remove(combination.size()-1);
       }
    }
}