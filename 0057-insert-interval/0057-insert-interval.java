class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) return new int [][]{{newInterval[0],newInterval[1]}};
        List<int []> res = new ArrayList<>();
        int count  = 0;
        for(int [] interval : intervals){
            if(res.isEmpty()){
                if(interval[0] > newInterval[1]){
                    res.add(newInterval);
                    res.add(interval);
                    continue;
                }
                else if(interval[1] < newInterval[0]){
                    res.add(interval);
                    res.add(newInterval);
                    continue;
                }else {
                    int [] current = new int []{interval[0],interval[1]};
                    current[0] = Math.min(current[0],newInterval[0]);
                    current[1] = Math.max(current[1],newInterval[1]);
                    res.add(current);
                }
            }else{
                int [] last = res.get(res.size()-1);
                if(last[0] > interval[1]){
                    res.remove(res.size()-1);
                    res.add(interval);
                    res.add(last);
                    continue;
                }
                else if(last[1] < interval[0]){
                    res.add(interval);
                    continue;

                }else{
                    int x= Math.min(last[0],interval[0]);
                    int y = Math.max(last[1],interval[1]);
                    res.remove(res.size()-1);
                    res.add(new int[]{x,y});
                }
            }
        }

        return res.toArray(new int[res.size()][]);
       
    }
}