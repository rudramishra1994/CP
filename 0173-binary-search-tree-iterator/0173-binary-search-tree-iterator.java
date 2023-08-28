/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Queue<TreeNode> inorder;
    public BSTIterator(TreeNode root) {
        inorder = new LinkedList<>();
        DFS(root);

    }

    private void DFS(TreeNode root){
        if(root == null) return;
        DFS(root.left);
        inorder.add(root);
        DFS(root.right);
    }

    
    public int next() {
        return inorder.poll().val;
    }
    
    public boolean hasNext() {
        return inorder.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */