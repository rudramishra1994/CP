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
    Map<Integer,Integer> idxMap = new HashMap<>();
    int idx = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
          idx = postorder.length-1;
        for(int i = 0 ; i < inorder.length ;i++){
            idxMap.put(inorder[i],i);
        }
        
        return constructBinaryTree(postorder,0,inorder.length-1);
    }
    private TreeNode constructBinaryTree(int[] preOrder,int m ,int n){
        if(m > n) return null;
        TreeNode root = new TreeNode(preOrder[idx--]);
        //if(idx == preOrder.length-1) return root;
        int rootInorderIdx = idxMap.get(root.val);
        root. right = constructBinaryTree(preOrder,rootInorderIdx+1,n);
        root.left = constructBinaryTree(preOrder,m,rootInorderIdx-1);
        return root;
    }
}