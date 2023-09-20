class Solution {
    public int maxPoints(int[][] points) {
        if(points.length < 3) return points.length;
        
        int max = Integer.MIN_VALUE;
        for(int [] point : points){
            Map<Double,Integer> p = new HashMap<>();
            for(int [] other : points){
                if(point[0]==other[0] && point[1]==other[1]) continue;
                double angle = 0;
                if(other[0] == point[0]) angle = Double.MAX_VALUE;
                else angle = (1.0*(point[1]-other[1]))/(point[0]-other[0]);

                int count = p.getOrDefault(angle,1);
                p.put(angle,count+1);

                max = Math.max(max,count+1);

            }
        }
        return max;
    }
}