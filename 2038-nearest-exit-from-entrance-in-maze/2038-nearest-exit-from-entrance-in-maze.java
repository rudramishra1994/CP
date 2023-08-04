class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int []> q = new LinkedList<>();
        int n = maze.length;
        int m = maze[0].length;
        q.add(new int[] {entrance[0],entrance[1],0});
        int [][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        boolean[][]visited = new boolean [n][m];
        visited[entrance[0]][entrance[1]] = true;
        while(!q.isEmpty()){
            int [] node = q.poll();
            for(int [] dir : dirs){
                int childRow = node[0]+dir[0];
                int childCol = node[1]+dir[1];
                
                if(0 <= childRow && childRow <= n-1 && 0 <= childCol && childCol 
                <= m-1 && maze[childRow][childCol] == '.'&& !visited[childRow][childCol]){
                    if(childRow == 0 || childCol ==0 || childRow == n-1 ||childCol==m-1)return node[2]+1;
                    q.add(new int []{childRow,childCol,node[2]+1});
                    visited[childRow][childCol] = true;
                }
            }

        }
        return -1; 

    }


    

}