class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int [][] pair = new int [n][2];

        for(int i = 0 ; i < n ;i++){
            pair[i][0] = nums2[i];
            pair[i][1] = nums1[i];
        }

        Arrays.sort(pair,(a,b) -> Integer.compare(b[0],a[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long maxscore = 0,sum = 0;
        for(int i = 0 ; i < n; i++){  
            if(minHeap.size() < k){
                minHeap.offer(pair[i][1]);
                sum += pair[i][1];
            }
            if(minHeap.size() == k){
                maxscore = Math.max(maxscore,sum * pair[i][0]);
                sum -= minHeap.poll();
            }
        }

        

        return maxscore;
        


    }
}