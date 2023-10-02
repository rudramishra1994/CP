class Solution {
    // topological sorting type algorithm
    // continue trimming leaf nodes till the till <=2 nodes remain
    // maximum 2 centroids possible in a tree
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n < 2){
            List<Integer> ans = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){
                ans.add(i);
            }
            return ans;
        }
        Map<Integer,Set<Integer>> adj = new HashMap<>();
        for(int [] edge : edges){
            adj.putIfAbsent(edge[0],new HashSet<>());
            adj.putIfAbsent(edge[1],new HashSet<>());
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for(int key : adj.keySet()){
            if(adj.get(key).size() ==1) leaves.add(key);
        }
        
        int numberOfNodes = n;
        while(numberOfNodes > 2){
            numberOfNodes-=leaves.size();
            List<Integer> nextLayer = new ArrayList<>();
            for(int leaf : leaves){
                int neighbor = adj.get(leaf).iterator().next();
                adj.get(neighbor).remove(leaf);
                if(adj.get(neighbor).size() == 1) nextLayer.add(neighbor);
            }
            
            leaves = nextLayer;
           
        }

        return leaves;
    }
}