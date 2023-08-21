class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int count = 1, maxCount = 0;
        for(int num : nums){
            if(!set.contains(num -1)){
                int start = num;
                while(set.contains(start+1)) {
                    count++;
                    start = start+1;    
                }
                maxCount = Math.max(maxCount,count);
                count =1;

            }
        }
        return maxCount;
    }
}