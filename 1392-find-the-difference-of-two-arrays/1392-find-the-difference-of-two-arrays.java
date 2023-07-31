class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> distinctNums1 = new HashSet<>();
        Set<Integer> distinctNums2 = new HashSet<>();

        for(int i : nums1){
            distinctNums1.add(i);
        }
        for(int i : nums2){
            distinctNums2.add(i);
        }
        List<Integer> temp = new ArrayList<>();
        for(int i : distinctNums1){
            if(distinctNums2.contains(i)){
                distinctNums2.remove(i);
            }else {
                temp.add(i);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(temp);
        ans.add(new ArrayList<>(distinctNums2));


        return ans;


    }
}