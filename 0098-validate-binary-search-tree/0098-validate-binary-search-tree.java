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
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        return dfs(root);
    }
    private boolean dfs(TreeNode root){
        if(root == null)  return true;
        boolean left = dfs(root.left);
        boolean validNode = true;
        if(prev!=null){
            validNode = prev.val < root.val;
        }
        prev = root;
        return left && dfs(root.right) && validNode;

    }
}