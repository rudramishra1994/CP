class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Arrays.asList(Arrays.stream(sticks).boxed().toArray(Integer[]::new)));
        int minCost = 0;
        while(pq.size() > 1){
            int cost = pq.poll() + pq.poll();
            minCost+=cost;
            pq.add(cost);
        }
        return minCost;
    }
}