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
    TreeNode ancestor=null;
    int i=0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca(root,p,q);
        
        return ancestor;
    }
    
    boolean lca(TreeNode node, TreeNode p, TreeNode q){
        if(node==null) return false;
        
        if(node == p || node == q){
            ancestor=node;
            return true;
        }
        boolean left=false,right=false;
        if(node.val>p.val && node.val>q.val)  return lca(node.left,p,q);
        else if(node.val>p.val && node.val>q.val) return lca(node.right,p,q);
        
        left=lca(node.left,p,q);
        right=lca(node.right,p,q);
       
        if(i==0 && left && right){
            ancestor=node;
            i++;
        }
        
        return left || right;
        
    }
}