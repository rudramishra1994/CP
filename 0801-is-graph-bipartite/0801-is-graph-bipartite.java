class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int [] color = new int [n];
        /**
            0  - unvisited;
            1  - blue;
            -1 - red;
         */
        

        
        for(int i = 0 ; i < n ;i++){
            if(color[i] == 0){
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 1;
                while(!q.isEmpty()){
                int currNode = q.poll();
                for(int node: graph[currNode]){
                    if(color[node] == 0){
                        color[node] = -color[currNode];
                        q.add(node);
                    }else if (color[node] == color[currNode]) return false;
                }
            }
        }
       
        } 
        return true;



    }
}