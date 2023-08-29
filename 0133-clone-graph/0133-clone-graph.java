/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        return deepCopy(node,new HashSet<>(),new HashMap<>());
    }

    private Node deepCopy(Node oldRoot,Set<Node> visited,Map<Node,Node>old_new){
        if(oldRoot == null) return null;
        if(visited.contains(oldRoot)) return old_new.get(oldRoot);
        visited.add(oldRoot);
        Node newNode = new Node(oldRoot.val);
        old_new.put(oldRoot,newNode);
        for(Node root : oldRoot.neighbors){
            newNode.neighbors.add(deepCopy(root,visited,old_new));
        }
        return newNode;
    }
}