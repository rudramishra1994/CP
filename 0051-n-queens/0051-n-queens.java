class Solution {
    // Set<Integer> col = new LinkedHashSet<>();
    // Set<Integer> pDiag = new LinkedHashSet<>();
    // Set<Integer> nDiag = new LinkedHashSet<>();
    List<List<String>> combinations = new ArrayList<>();
    int dim;
    char [][] board;
    public List<List<String>> solveNQueens(int n) {
        this.dim = n;
        board = new char[n][n];
        for(char [] row : board) Arrays.fill(row,'.');
        backtrack(n,0, new LinkedHashSet<>(), new HashSet<>(), new HashSet<>());
        return combinations;
    }
    private void backtrack(int n,int row,  Set<Integer> col,Set<Integer> pDiag, Set<Integer> nDiag){
        if(n==0){
           addStateToResult();
        }
        
        for(int i = 0 ; i < dim ; i++){
            if(col.contains(i) || pDiag.contains(row+i) || nDiag.contains(row-i)) continue;
            col.add(i);
            pDiag.add(row + i);
            nDiag.add(row - i);
            board[row][i] = 'Q';
            backtrack(n-1,row+1,col,pDiag,nDiag);
            col.remove(i);
            pDiag.remove(row+i);
            nDiag.remove(row-i);
            board[row][i] = '.';

        }
    }

    private void addStateToResult(){
            List<String> combination = new ArrayList<>();
            for(char [] row : board){
                combination.add(new String(row));
            }
            combinations.add(combination);
    }
}