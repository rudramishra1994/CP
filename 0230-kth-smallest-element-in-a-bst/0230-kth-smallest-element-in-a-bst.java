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
class Solution {

    TreeNode kSmallest = null;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorderDFS(root,k);
        return kSmallest.val;
    }
    private void inorderDFS(TreeNode root,int k){
        if(root == null) return;
        inorderDFS(root.left,k);
        count++;
        if(count == k) kSmallest = root;
        inorderDFS(root.right,k);
    }
}