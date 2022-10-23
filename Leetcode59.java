
/***
 * Spiral Matrix II
 */
class Leetcode59 {
    public int[][] generateMatrix(int n) {
        int row = 0,col =0;
        int d = 0;
        int r = 0, c = 0;
        int count  = 1;
        int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        int [][]res  = new int [n][n];
        while (count <= n*n){
            res[row][col]  = count++;
            r = (row + dir[d][0]+n) % n;
            c = (col + dir[d][1]+n) % n;
            if(res[r][c] != 0) d = (d+1)%4;
            row += dir[d][0];
            col += dir[d][1];
        }
        return res;
    }
}