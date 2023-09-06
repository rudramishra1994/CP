class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> genes = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        if(!isPresent(endGene,bank)) return -1;
        genes.add(startGene);
        char [] geneChar = new char []{'A','C','G','T'};
        int count = 0 ;
        while(!genes.isEmpty()){
            int size = genes.size();
            for(int j = 0 ; j < size ;j++){
                String mutant = genes.poll();
                if(mutant.equals(endGene)) return count;
                visited.add(mutant);
                for(int i = 0 ; i < 8 ; i++){
                    for(char c : geneChar){
                        StringBuilder br = new StringBuilder();
                        br.append(mutant.substring(0,i)).append(c).append(mutant.substring(i+1));
                        if(isPresent(br.toString(),bank)&&!visited.contains(br.toString())) genes.add(br.toString());
                    }
                }
            }
          
            count++;
        }
        return -1;
    
    }

    private boolean isPresent(String startGene, String [] bank){
        for(String s : bank){
            if(s.equalsIgnoreCase(startGene)) return true;
        }

        return false;
    }
        
}