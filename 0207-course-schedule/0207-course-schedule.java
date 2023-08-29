class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length ==0)return true;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }
        boolean [] visited = new boolean[numCourses];
        boolean [] dfsStack = new boolean[numCourses];
        
        for(int i = 0 ; i < numCourses;i++){
                if(cycleFound(i,adj,visited,dfsStack)) return false;
                
        }

        return true;

    }
    private boolean cycleFound(int node,List<List<Integer>> adj,boolean [] visited, boolean [] dfsStack){
            if(dfsStack[node]) return true;
            if(visited[node]) return false;
            visited[node] = true;
            dfsStack[node] = true;
            for(int child : adj.get(node)){
                if(cycleFound(child,adj,visited,dfsStack)) return true;
            }
            dfsStack[node] = false;
            return false;

    }
}