class Solution {
    public int minimumOperations(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : nums){
            if(i > 0) pq.add(i);
        }
        int count = 0;
        while(!pq.isEmpty()){
            int smallest = pq.poll();
            count++;
            PriorityQueue<Integer> pq2 = new PriorityQueue<>();
            while(!pq.isEmpty()){
                int k = pq.poll();
                k -=smallest;
                if(k > 0) pq2.add(k);
            }
            pq = pq2;
        }
        return count;

    }
}