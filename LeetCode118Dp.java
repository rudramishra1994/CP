class LeetCode118Dp {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        answer.add(new ArrayList<>(Arrays.asList(1)));
        if (numRows==1) return answer;
        answer.add(new ArrayList<>(Arrays.asList(1,1)));
        if(numRows==2) return answer;
        for(int k = 3 ;k <= numRows;k++){
            List<Integer> prevRow = answer.get(answer.size()-1);
            List<Integer> nextRow = new ArrayList<>(Arrays.asList(1,1));
            int pos = 1;
            for(int i = 0; i < prevRow.size()-1;i++){
                nextRow.add(pos,prevRow.get(i)+prevRow.get(i+1));
                pos++;
            }
            answer.add(nextRow);
                
        }
        return answer;
    }
        
}