class Solution {
    public int kthFactor(int n, int k) {
        int sqrtN = (int)Math.ceil(Math.sqrt(n));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i = 1 ; i <=sqrtN ;i++){
            if(n%i == 0){
                if(!pq.contains(i)) pq.add(i);
                if(!pq.contains(n/i))pq.add(n/i);
                while(pq.size() > k) pq.poll();
            }
        }
        return pq.size() >=k?pq.peek() : -1;
    }
}