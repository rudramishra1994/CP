class Solution {
    double val = 1.0;
    boolean found = false;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Set<String> nodes = new HashSet<>();
        double [] ans = new double [queries.size()];
        int pos = 0;
        
        Map<String,List<String[]>> neighbor = new HashMap<>();
        for(List<String> edge : equations){
            String src = edge.get(0);
            String dest = edge.get(1);
            nodes.add(src);
            nodes.add(dest);
            if(!neighbor.containsKey(src)){
                List<String[]> c = new ArrayList<>();
                String [] s = {dest,String.valueOf(values[pos])};
                c.add(s);
                neighbor.put(src,c);
            } else {
                List<String []> c = neighbor.get(src);
                String [] s = {dest,String.valueOf(values[pos])};
                c.add(s);
            }

            if(!neighbor.containsKey(dest)){
                List<String[]> c = new ArrayList<>();
                String [] s = {src,String.valueOf(1.0/values[pos])};
                c.add(s);
                neighbor.put(dest,c);
            } else {
                List<String []> c = neighbor.get(dest);
                String [] s = {src,String.valueOf(1.0/values[pos])};
                c.add(s);
            }

            pos++;
        }
        pos = 0;
        for(List<String> query : queries){
            String src = query.get(0);
            String dest = query.get(1);
            found = false;
            val = 1;
            Set<String> visited = new HashSet<>();
            if(nodes.contains(src) && nodes.contains(dest)){
                if(src.equals(dest)) ans[pos++] = 1.0 * 1;
                else{
                    dfs(neighbor,visited,src,dest,1.0);
                    ans[pos++] = found? val: -1;
                } 

            }else ans[pos++] = 1.0 * -1; 
        }

        return ans;
    }

    private void dfs(Map<String,List<String[]>> neighbor,Set<String> visited,String src,String dest,double cost){
        visited.add(src);
        for(String [] pair : neighbor.get(src)){
            if(!visited.contains(pair[0])){
                if(pair[0].equals(dest)) {
                    val = cost * Double.parseDouble(pair[1]);;
                    found = true;
                    return;
                }else if (!found && !visited.contains(pair[0])){
                    dfs(neighbor,visited,pair[0],dest,cost * Double.parseDouble(pair[1]));
                }
            }
        }
    }
}