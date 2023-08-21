class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int []> res = new ArrayList<>();
        int count = 0;int [] current = null;
        for(int [] interval : intervals){
            if(current == null){
                current = interval;
                continue;
            }
            count++;
            if (interval[1] > current[1] && interval[0] <= current[1]) current[1] = interval[1];
            else if (interval[0] > current[1]) {
                    res.add(current);
                    current = interval;
            }
           
        }
        if(count == intervals.length-1) res.add(current);    
        return res.toArray(new int [res.size()][]);
    }
}