class Solution {
    public int minReorder(int n, int[][] connections) {
       Set<String> original = new HashSet<>();
       List<List<Integer>> neighbor = new ArrayList<>();
       for(int i = 0; i < n; i++){
           List<Integer> temp = new ArrayList<>();
           neighbor.add(temp);
       }
        for(int [] c : connections){
           List<Integer> temp1 = neighbor.get(c[0]);
           temp1.add(c[1]);
           List<Integer> temp2 = neighbor.get(c[1]);
           temp2.add(c[0]);
           original.add(c[0] + "->"+c[1]);
        } 
        return BFS(0,original,neighbor);
    }

    private int BFS(int root,Set<String>original,List<List<Integer>> neighbor){
        Queue<Integer> q = new LinkedList<>();
        boolean [] visited = new boolean [neighbor.size()];
        int count = 0;
        q.add(root);
        while(!q.isEmpty()){
            int curr = q.poll();
            visited[curr] = true;
            for(int i : neighbor.get(curr)){
                if(visited[i]) continue;
                q.offer(i);
                if(original.contains(curr+"->"+i)) count++;
            }

        }
        return count;
    }
}