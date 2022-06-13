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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return false;
        // if(root.left==null && root.right!=null) return false;
        // if(root.left!=null && root.right==null) return false;
        return symmetric(root.left,root.right);
    }
    
    boolean symmetric(TreeNode nodeleft,TreeNode noderight){
        if(nodeleft==null && noderight==null) return true;
        if(nodeleft==null || noderight==null) return false;
        
        if(nodeleft.val!=noderight.val) return false;
        boolean left = symmetric(nodeleft.left,noderight.right);
        boolean right = symmetric(nodeleft.right,noderight.left);
        
        return left && right;
    }
}