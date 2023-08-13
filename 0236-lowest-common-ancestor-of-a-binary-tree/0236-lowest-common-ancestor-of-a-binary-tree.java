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
    TreeNode ancestor = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        
        return ancestor;
    }
    
    boolean dfs(TreeNode node, TreeNode p, TreeNode q){
        if(node == null) return false;
        
        boolean left = dfs(node.left, p, q);
        boolean right = dfs(node.right, p, q);
        
        if((left && right) || ((left || right) && (node == p || node == q))){
            ancestor = node;
            return true;
        }
        
        if(node == p || node == q) return true;
        
        return left || right;
    }
}