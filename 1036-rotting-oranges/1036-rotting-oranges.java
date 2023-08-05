class Solution {
    public int orangesRotting(int[][] grid) {
        int freshOrange = 0 , rottenOrange = 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<int []> q = new LinkedList<>();
        for(int i = 0; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1) freshOrange++;
                else if (grid[i][j] == 2) {
                    q.add(new int []{i,j});
                    rottenOrange++;
                }
            }
        }
        if(freshOrange < 1) return 0;
        if(rottenOrange < 1) return -1;
        q.add(new int[]{-1,-1});
        int count = 0;
        int [][] dirs = new int [][] {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int [] orange = q.poll();
            if(orange[1]==-1 && q.isEmpty()) break;
            else if (orange[1] == -1 && !q.isEmpty()) {
                count++;
                q.add(new int[]{-1,-1});
            }
            for(int []dir : dirs){
                int nextX = orange[0] + dir[0];
                int nextY = orange[1] + dir[1];
                if(0<=nextX && nextX < n && 0 <=nextY && nextY < m && grid[nextX][nextY]==1){
                    grid[nextX][nextY] = 2;
                    q.add(new int[]{nextX,nextY});
                    freshOrange--;
                }
            }
        }

        return freshOrange > 0 ? -1 : count;



    }
}