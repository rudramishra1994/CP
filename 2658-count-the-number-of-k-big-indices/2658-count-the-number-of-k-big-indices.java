class Solution {
    public int kBigIndices(int[] nums, int k) {
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        boolean [] valid = new boolean [nums.length];

        for(int i = 0 ; i < nums.length ; i++){
            if(max_heap.size() == k && nums[i] > max_heap.peek()) valid[i] = true;
            max_heap.add(nums[i]);
            if(max_heap.size() > k) max_heap.poll();
        }
        int count = 0;
        max_heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = nums.length-1 ; i >=0 ; i--){
            if(max_heap.size() == k && nums[i] > max_heap.peek() && valid[i]) count++;
            max_heap.add(nums[i]);
            if(max_heap.size() > k) max_heap.poll();
        }
        return count;


    }
}