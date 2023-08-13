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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }
    
    boolean dfs(TreeNode nodep, TreeNode nodeq){
        if(nodep == null && nodeq == null){
            return true;
        }
        if(nodep == null || nodeq == null){
            return false;
        }
        
        if(nodep.val != nodeq.val) return false;
        
        boolean left = dfs(nodep.left, nodeq.left);
        boolean right = dfs(nodep.right, nodeq.right);
        
        return left && right;
    }
}