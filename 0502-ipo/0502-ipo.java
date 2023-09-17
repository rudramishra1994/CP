class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int [][] p_c = new int [n][2];
        for(int i = 0 ; i < n ; i++){
            p_c[i] = new int [] {profits[i],capital[i]};
        }

        PriorityQueue<int []> p = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        Arrays.sort(p_c,(a,b) ->a[1]-b[1]);
        int j = 0;
        for(int i = 0; i < k ;i++){
            while(j < n && p_c[j][1] <= w) p.add(p_c[j++]);
            if(p.isEmpty()) break;
            w +=p.poll()[0];

        }
        return w;

    }
}