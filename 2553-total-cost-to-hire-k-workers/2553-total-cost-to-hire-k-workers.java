class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue <Integer> front = new PriorityQueue<>();
        PriorityQueue <Integer> rear = new PriorityQueue<>();
        int n = costs.length;
        long answer = 0;
        int nextFront = candidates;
        int nextRear  = n-1-candidates;
        for(int i = 0 ; i < candidates;i++){
            front.add(costs[i]);
        }
        for(int i = Math.max(candidates,n-candidates);i < n;i++){
            rear.add(costs[i]);
        }
        for(int i = 0; i < k ;i++){
            if(rear.isEmpty() || (!front.isEmpty() && front.peek() <=rear.peek())){
                answer += front.poll();
                if(nextFront <= nextRear){
                    front.add(costs[nextFront++]);
                }
            }else if(front.isEmpty() ||(!rear.isEmpty() && rear.peek() < front.peek())){
                answer+=rear.poll();
                if(nextFront <= nextRear){
                    rear.add(costs[nextRear--]);
                }
            }
        }

        return answer;

        
    }
}