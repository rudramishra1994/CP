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

    int minDiff = Integer.MAX_VALUE ;
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return minDiff;
    }

    private void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        if(prev!=null){
            minDiff = Math.min(minDiff,Math.abs(prev.val-root.val));
        }
        prev = root;
        dfs(root.right);
    }
    
}