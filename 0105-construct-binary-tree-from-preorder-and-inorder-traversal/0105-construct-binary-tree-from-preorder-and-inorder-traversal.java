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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i = 0 ; i < inorder.length ;i++){
            idxMap.put(inorder[i],i);
        }
        
        return constructBinaryTree(preorder,inorder,0,inorder.length-1);
    }

    private TreeNode constructBinaryTree(int[] preOrder,int [] inOrder,int m ,int n){
        if(m > n) return null;
        TreeNode root = new TreeNode(preOrder[idx++]);
        //if(idx == preOrder.length-1) return root;
        int rootInorderIdx = idxMap.get(root.val);
        root.left = constructBinaryTree(preOrder,inOrder,m,rootInorderIdx-1);
        root. right = constructBinaryTree(preOrder,inOrder,rootInorderIdx+1,n);
        return root;
    }
}