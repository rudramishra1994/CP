class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((a,b)->{
            int c = b.getValue()-a.getValue();
            if(c==0) return b.getKey()-a.getKey();
            else return c;
        });
        for(int i= 0; i < mat.length;i++){
            int ones = 0;
            for(int j : mat[i]){
                if(j==1) ones++;
                else break;
            }
            pq.add(new Pair<>(i,ones));
            if(pq.size() > k) pq.poll();
        }
        int [] ans = new int [k];
        int i = k-1;
        while(!pq.isEmpty()) ans[i--] = pq.poll().getKey();
        return ans;

    }
}