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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> kSum = new PriorityQueue<>();
 
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){

            int n = q.size();
            int i = 0;
            long sum = 0;
            while(i < n){
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right); 
                i++;  
            }
            kSum.add(sum);
            if(kSum.size() > k) kSum.poll();
          
        }
   

        return kSum.size() == k ? kSum.peek() : -1;
    }
}