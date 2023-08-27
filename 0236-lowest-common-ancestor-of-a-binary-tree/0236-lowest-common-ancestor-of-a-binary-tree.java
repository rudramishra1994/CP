/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
   
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLCA(root,p,q);
        return lca;

    }

    public boolean findLCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;
        int first = findLCA(root.left,p,q) ? 1 : 0;
        int second = findLCA(root.right,p,q) ? 1 : 0;

        int self = 0;
        if(root == p || root == q) self = 1;
        if(first+second+self >=2) {
            lca = root;
        }
        return first+second+self >0;

    }
}