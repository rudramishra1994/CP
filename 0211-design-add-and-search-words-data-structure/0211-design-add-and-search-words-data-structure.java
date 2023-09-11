class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(node.children[c-'a']==null) {
                node.children[c-'a'] = new TrieNode();
                //node = node.children[c-'a'];
            }
            node = node.children[c-'a'];
        }
        node.isEndNode = true;
    }
    
    public boolean search(String word,TrieNode node) {
        for(int i = 0 ; i < word.length();i++){
            char ch = word.charAt(i);
            if(ch == '.'){
                for(TrieNode child : node.children){
                    if(child !=null){
                        if(search(word.substring(i+1),child)) return true;
                    }
                }
            return false;
            }else if(node.children[ch-'a']!=null){
                node = node.children[ch-'a'];
            }else if(node.children[ch-'a'] == null) return false;
        }
        return node.isEndNode;
    }

    public boolean search(String word){
        return search(word,root);
    }
}
 class TrieNode{
        boolean isEndNode;
        TrieNode [] children;
        TrieNode(){
            isEndNode = false;
            children = new TrieNode[26];
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */