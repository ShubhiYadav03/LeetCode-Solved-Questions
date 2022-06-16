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
    public boolean isValidBST(TreeNode root) {       
        return valid(root,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
    }
    boolean valid(TreeNode node,double l,double r){
        if(node==null) return true;
        
        if(node.val>=r || node.val<=l) return false;
        
        boolean left=valid(node.left,l,node.val);
        boolean right=valid(node.right,node.val,r);
        
        return left && right;
    }
}