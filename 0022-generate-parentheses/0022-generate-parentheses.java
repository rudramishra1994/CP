class Solution {
    private List<String> validParenthesis = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(n,n,new StringBuilder());
        return validParenthesis;
    }

    private void backtrack(int lPar, int rPar,StringBuilder br){
        if(rPar == 0){
            validParenthesis.add(br.toString());
            return;
        }
        if(lPar > 0 && lPar <=rPar){
            br.append('(');
            backtrack(lPar-1,rPar,br);
            br.deleteCharAt(br.length()-1);
        }
        if(rPar > lPar && rPar > 0){
            br.append(')');
            backtrack(lPar,rPar - 1,br);
            br.deleteCharAt(br.length()-1);
        }

    }
}