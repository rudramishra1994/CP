class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int [][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        List<Integer> res = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0, j = 0;
        int curr = 0;
        while(res.size() < n*m){

            res.add(matrix[i][j]);
            matrix[i][j] = Integer.MIN_VALUE;
            if(!(i + dir[curr][0] >= 0 && i+dir[curr][0] < n && 
                    j+dir[curr][1] >=0 && j+dir[curr][1] < m && matrix[i+dir[curr][0]][j+dir[curr][1]] > Integer.MIN_VALUE)){
                        curr = (curr+1)%4;
            }
            i = i+dir[curr][0];
            j = j+dir[curr][1];
        }
        return res;
    }
}