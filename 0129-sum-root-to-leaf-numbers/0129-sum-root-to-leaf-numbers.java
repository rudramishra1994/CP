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
    int sum = 0 ;
    public int sumNumbers(TreeNode root) {
        totalValue(root,new StringBuilder());
        return sum;
    }

    private void totalValue(TreeNode root , StringBuilder pathSum){
        if(root == null) return;
        pathSum.append(root.val);
        if(root.left == null && root.right == null){
            sum = sum+Integer.parseInt(pathSum.toString());
            return;
        }
        totalValue(root.left,new StringBuilder(pathSum));
        totalValue(root.right,new StringBuilder(pathSum));

    }
}