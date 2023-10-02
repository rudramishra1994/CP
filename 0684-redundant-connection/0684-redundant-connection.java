class Solution {

    /**
        Union - find algorithm
     */
    int [] parent,rank=null;
    public int[] findRedundantConnection(int[][] edges) {
        int n = Integer.MIN_VALUE;
        for(int [] edge : edges){
            if(n < edge[0]) n = edge[0];
            if(n < edge[1]) n = edge[1];
        }

        parent = new int [n+1];
        rank   = new int [n+1];

        for(int i = 0 ; i < n+1 ; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int [] edge : edges){
            if(!union(edge[0],edge[1])) return edge;
        }
        return new int [2];

    }

    private int find(int element){
        if(parent[element]!=element){
            parent[element] = find(parent[element]);
        }
        return parent[element];
    }

    private boolean union(int element1, int element2){
        int root1 = find(element1);
        int root2 = find(element2);

        if(root1 == root2) return false;
        if(rank[root1] > rank[root2]) parent[root2] = root1;
        else if(rank[root1] < rank[root2]) parent[root1] = root2;
        else {
            parent[root2] = root1;
            rank[root1]++;
        }
        return true;
    }
}