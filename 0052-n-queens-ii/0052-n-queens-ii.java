class Solution {
    int dim;
    public int totalNQueens(int n) {
        this.dim = n;
        return backtrack(n,0, new LinkedHashSet<>(), new HashSet<>(), new HashSet<>());

    }
 
    private int backtrack(int n,int row,  Set<Integer> col,Set<Integer> pDiag, Set<Integer> nDiag){
        if(n==0){
           return 1;
        }
        int count = 0;
        for(int i = 0 ; i < dim ; i++){
            if(col.contains(i) || pDiag.contains(row+i) || nDiag.contains(row-i)) continue;
            col.add(i);
            pDiag.add(row + i);
            nDiag.add(row - i);
            count+=backtrack(n-1,row+1,col,pDiag,nDiag);
            col.remove(i);
            pDiag.remove(row+i);
            nDiag.remove(row-i);
            

        }
        return count;
    }

}