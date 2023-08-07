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


/**
    Time complexity O(n*n) not efficient. Improve using prefix sum method.
 */
class Solution {
    int path = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return pathSum(root.left,targetSum) + pathSum(root.right,targetSum) + dfs(root,targetSum);
    }

    private int  dfs(TreeNode root,long targetSum){
      if(root == null) return 0;
      int res = 0 ;
      if(root.val == targetSum){
          res = 1; 
      } 
      res += dfs(root.left,targetSum - root.val);
      res += dfs(root.right,targetSum - root.val);
      return res;
    }


}