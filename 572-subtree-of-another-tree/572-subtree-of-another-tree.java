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
    //ans=true;
    public boolean isSubtree(TreeNode root, TreeNode subroot) {
         if(subroot ==null)
            return true;
        if(root==null) return false;
        
        if(isSame(root,subroot)){
            return isSame(root,subroot);
        }
        
        boolean left = isSubtree(root.left,subroot);
        boolean right = isSubtree(root.right,subroot);
        
        return left || right;
    }
    
    boolean isSame(TreeNode root, TreeNode subroot){
         if(root==null || subroot == null)
            return root == subroot;
        
        if(root.val!=subroot.val){
            return false;
        }
        
        boolean left = isSame(root.left,subroot.left);
        boolean right = isSame(root.right,subroot.right);
        
        return left && right;
    }
}