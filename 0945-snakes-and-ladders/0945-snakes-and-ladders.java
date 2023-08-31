class Solution {
    public int snakesAndLadders(int[][] board) {
        Map<Integer, int []> label_pos = new HashMap<>();
        boolean left2right = true;
        int label = 1;
        int n = board.length;
        int m = board[0].length;
        for(int i = n-1 ; i >=0 ;i--){
            for(int j = 0 ; j < m; j++){
                label_pos.put(label++,new int []{i,left2right?j:board[0].length-1-j});
            }
            left2right = !left2right;
        }

        int [] distance = new int [n*n + 1];
        Arrays.fill(distance,-1);
        distance[1] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()){
            int currNode = q.poll();
            if(currNode == 13)
            System.out.println(currNode);
            for(int child = currNode+1; child <=Math.min(currNode+6,n*n);child++){
                int childX = label_pos.get(child)[0];
                int childY = label_pos.get(child)[1];
                
                int childLabel = board[childX][childY] != -1 ? board[childX][childY] : child;
                if(distance[childLabel] == -1){
                    distance[childLabel] = distance[currNode]+1;
                    q.add(childLabel);
                }

                
            }

        }
        return distance[n*n];
    }
}