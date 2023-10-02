class Solution {
    // topological sorting type algorithm
    // continue trimming leaf nodes till the till <=2 nodes remain
    // maximum 2 centroids possible in a tree
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
         if (n < 2) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ans.add(i);
            }
            return ans;
        }
        
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        int[] degree = new int[n];
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
            degree[u]++;
            degree[v]++;
        }
        
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                leaves.add(i);
            }
        }
        
        int numberOfNodes = n;
        while (numberOfNodes > 2) {
            numberOfNodes -= leaves.size();
            List<Integer> nextLayer = new ArrayList<>();
            for (int leaf : leaves) {
                int neighbor = adj[leaf].get(0);
                adj[leaf].remove(0);
                adj[neighbor].remove((Integer) leaf);
                degree[neighbor]--;
                if (degree[neighbor] == 1) {
                    nextLayer.add(neighbor);
                }
            }
            leaves = nextLayer;
        }
        
        return leaves;
    }
}