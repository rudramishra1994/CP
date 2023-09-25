class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0 ;
        int n = matrix.length;
        int m = matrix[0].length;
        boolean hasOne = false;
        for(int i = 0; i<n;i++){
            for(int j = 0 ; j < m ; j++){
                if(matrix[i][j]== '1'){
                    hasOne = true;
                    int k = 0;
                    if(i-1 >=0 && j-1>=0)
                        k = Math.min(matrix[i-1][j-1],Math.min(matrix[i-1][j],matrix[i][j-1])) - 48;
                    matrix[i][j] = (char)((int)matrix[i][j] + k);
                    max = Math.max(max,(matrix[i][j] - 48));
                }
            }
        }
        
        return max > 1 ? max*max : hasOne ? 1 : 0;
    }
}