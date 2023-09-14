class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int  size = matrix[0].length * matrix.length;
        int col = matrix[0].length;
        int left = 0,right = size-1;
        while(left < right){
            int mid = left+(right-left)/2;
            int midVal = matrix[mid/col][mid%col];
            if( midVal < target) left = mid+1;
            else if (midVal > target) right = mid -1;
            else return true;
        }
        return matrix[left/col][left%col] == target;
    }
}