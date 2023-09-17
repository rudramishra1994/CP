class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue <Pair> p = new PriorityQueue<>((a,b) -> a.sum - b.sum);
        for(int i = 0; i < nums1.length;i++){
            p.offer(new Pair(nums1[i]+nums2[0],i,0));
        }
        while(k > 0 && !p.isEmpty()){
            Pair pair = p.poll();
            int i = pair.pair[0];
            int j = pair.pair[1];
            ans.add(new ArrayList<>(Arrays.asList(nums1[i],nums2[j])));
            k--;
            if(j+1 < nums2.length) p.add(new Pair(nums1[i]+nums2[j+1],i,j+1));
        }


        return ans;
    }

    private class Pair{
        int sum;
        int [] pair;

        Pair(int sum,int i, int j){
            this.sum = sum;
            pair = new int []{i,j};

        }
    }
}