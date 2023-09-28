class Solution {

    TrieNode root;
    
    public List<String> findWords(char[][] board, String[] words) {
        createTrie(words);
        Set<String> ans = new HashSet<>();
        for(int i = 0 ; i < board.length;i++)
            for(int j = 0 ; j < board[0].length;j++)
                //backtrack(board,i,j,root,new StringBuilder (),ans);
                backtrack2(board,i,j,root,ans);
        return new ArrayList<>(ans);

        
    }

    private void backtrack(char [][] board,int x,int y,TrieNode node,StringBuilder br,Set<String> ans){
        if(x < 0 || y < 0 || x >=board.length || y >=board[0].length || board[x][y] =='*') return ;
        char c = board[x][y];
        if(node.children[c-'a']==null) return;
        br.append(c);
        if(node.children[c-'a'].isEndNode){
            ans.add(br.toString());
        }
        int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        board[x][y] = '*';
        for(int [] dir : dirs){
            backtrack(board,x+dir[0],y+dir[1],node.children[c-'a'],br,ans);
        }
        board[x][y] = c;
        br.deleteCharAt(br.length()-1);
        if(node.children[c-'a'].isLeaf()) node.children[c-'a'] = null;
    }


      private void backtrack2(char [][] board,int x,int y,TrieNode node,Set<String> ans){
        if(x < 0 || y < 0 || x >=board.length || y >=board[0].length || board[x][y] =='*') return ;
        char c = board[x][y];
        if(node.children[c-'a']==null) return;
        if(node.children[c-'a'].isEndNode){
            ans.add(node.children[c-'a'].word);
        }
        int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        board[x][y] = '*';
        for(int [] dir : dirs){
            backtrack2(board,x+dir[0],y+dir[1],node.children[c-'a'],ans);
        }
        board[x][y] = c;
        if(node.children[c-'a'].isLeaf()) node.children[c-'a'] = null;
    }


    private void createTrie(String [] words){
        root = new TrieNode();
        for(String word : words){
            addWord(word);
        }
    }


    private class TrieNode{
        boolean isEndNode;
        TrieNode [] children;
        String word;

        TrieNode(){
            isEndNode = false;
            children = new TrieNode[26];
            word = null;
        }
        boolean isLeaf(){
            for(int i = 0 ; i < 26;i++){
                if(children[i]!=null) return false;
            }
            return true;
        }
    }
    private void addWord(String word){
        TrieNode tempNode = root;
        for(char c : word.toCharArray()){
            if(tempNode.children[c-'a'] == null){
                tempNode.children[c-'a'] = new TrieNode();
            }
            tempNode = tempNode.children[c-'a'];
        }
        tempNode.isEndNode = true;
        tempNode.word = word;
    }

    // private boolean isPresent(String word){
    //     TrieNode tempNode = root;
    //      for(char c : word.toCharArray()){
    //         if(tempNode.children[c-'a'] == null){
    //             return false;
    //         }
    //         tempNode = tempNode.children[c-'a'];
    //     }
    //     return tempNode.isEndNode ;
    // }

    // private boolean startsWith(String word){
    //     TrieNode tempNode = root;
    //      for(char c : word.toCharArray()){
    //         if(tempNode.children[c-'a'] == null){
    //             return false;
    //         }
    //         tempNode = tempNode.children[c-'a'];
    //     }
    //     return true ;
    // }


}