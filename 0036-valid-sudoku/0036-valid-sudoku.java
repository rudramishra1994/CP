class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean row = true;
        boolean col = true;
        boolean box = true;
        for(int i = 0 ; i < board.length && row ;i++){
            Set<Character> s = new HashSet<>(); 
            for(int j = 0 ; j < board[0].length && col;j++){
                if(board[i][j] =='.') continue;
                if(s.contains(board[i][j])) row = false;
                else s.add(board[i][j]);
            }
        }

        for(int i = 0 ; i < board[0].length && col ;i++){
            Set<Character> s = new HashSet<>(); 
            for(int j = 0 ; j < board.length && col;j++){
                if(board[j][i] =='.') continue;
                if(s.contains(board[j][i])) col = false;
                else s.add(board[j][i]);
            }
        }
        Set<Character>[][] matrix = new HashSet[3][3];

        // Initialize the sets
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = new HashSet<>();
            }
        }

         for(int i = 0 ; i < board.length && box ;i++){
            for(int j = 0 ; j < board[0].length && box;j++){
                if(board[i][j] =='.') continue;
                if(matrix[i/3][j/3].contains(board[i][j])) box = false;
                else matrix[i/3][j/3].add(board[i][j]);
            }
        }

        return col && row && box;


    }
}