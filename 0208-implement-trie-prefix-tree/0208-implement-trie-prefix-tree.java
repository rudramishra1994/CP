class TrieNode {
    public Character val;
    public boolean isEndNode;
    public Map<Character,TrieNode> children;

    TrieNode (Character val){
        this.val = val;
        isEndNode = false;
        children = new HashMap<>();
    }

     TrieNode (){
        isEndNode = false;
        children = new HashMap<>();
    }    

    @Override
    public int hashCode(){
        return Objects.hashCode(val);
    }
}


class Trie {
    
    TrieNode root;
    public Trie() {
        root = new TrieNode();   
    }
    
    public void insert(String word) {
       int i = 0;
       TrieNode node = root;
       while(i < word.length()){
           while(i < word.length() && node.children.containsKey(word.charAt(i))){
               node = node.children.get(word.charAt(i));
               i++;
           }
           if (i >= word.length()){
               node.isEndNode = true;
               return;
           }
           node.children.put(word.charAt(i),new TrieNode(word.charAt(i)));
           node = node.children.get(word.charAt(i));
           if(i == word.length()-1) node.isEndNode = true;
           i++;

       }
    }    
    public boolean search(String word) {
        int i = 0;
        TrieNode node = root;
        while(i < word.length()&&node.children.containsKey(word.charAt(i))){
            node = node.children.get(word.charAt(i));
            i++;
        }
        if( i >= word.length()) {
            return node.isEndNode;
        }

        return false;

        
    }
    
    public boolean startsWith(String prefix) {
        int i = 0;
        TrieNode node = root;
        while(i < prefix.length()&&node.children.containsKey(prefix.charAt(i))){
            node = node.children.get(prefix.charAt(i));
            i++;
        }
        if( i >= prefix.length()) {
            return true;
        }

        return false;

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */