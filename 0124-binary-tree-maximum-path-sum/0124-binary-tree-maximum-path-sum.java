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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return max;
    }

    private int solve(TreeNode root){
        if(root == null) return 0;
        //if(root.left == null && root.right == null) return max = root.val;
        int left = solve(root.left);
        int right = solve(root.right);


        max = Math.max(max,Math.max(left+root.val,root.val));
        max = Math.max(max,Math.max(right+root.val,root.val));
        max = Math.max(max,left+right+root.val);
        return Math.max(root.val,Math.max(left+root.val,right+root.val));
    }
}