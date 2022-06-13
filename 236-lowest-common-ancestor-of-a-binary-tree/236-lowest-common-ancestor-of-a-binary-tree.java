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
    TreeNode ancestor;
    int i=1;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       
        lca(root,p,q);
        
        // TreeNode left = lowestCommonAncestor(root.left,p,q);
        // TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        // if(left==null) return right;
        // if(right==null) return left;
        
        return ancestor;
       
    }
    
    boolean lca(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return false;
        
        if(root == q || root == p) {
            ancestor = root;
            return true;
        }
        boolean left = lca(root.left,p,q);
        boolean right = lca(root.right,p,q);
        
        if(i==1 && left && right){
            ancestor=root;
            i++;
        }
        
        return left || right;
    }
   

}