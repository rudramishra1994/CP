class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<>());
        }

        for(int [] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }
        Stack<Integer> order = new Stack<>();
        boolean [] visited = new boolean[numCourses];
        boolean [] inStack = new boolean[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            if(topologicalSort(i,adj,visited,order,inStack)){
                return new int []{};
            }
        }
        //if(order.size() < numCourses) return new int [] {};
        int [] arr = new int [numCourses];
        int count = 0;
        while(!order.isEmpty()) arr[count++] = order.pop();
        
        return arr;
        


    }

    private boolean topologicalSort(int node, List<List<Integer>> adj, boolean [] visited,Stack<Integer> order,boolean [] inStack){
        if(inStack[node]) return true;
        if(visited[node]) return false;
        visited[node] = true;
        inStack[node] = true;
        for(int child : adj.get(node)){
            if(topologicalSort(child,adj,visited,order,inStack)){
                return true;
            }
           
        }
        order.add(node);
        inStack[node] = false;
        return false;
    }
}