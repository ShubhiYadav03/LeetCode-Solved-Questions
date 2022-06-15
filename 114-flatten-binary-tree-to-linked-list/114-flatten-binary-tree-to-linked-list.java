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
    public void flatten(TreeNode root) {
        flat(root);
    }
    TreeNode flat(TreeNode node){
        if(node==null) return node;
        
        TreeNode left=flat(node.left);
        TreeNode right=flat(node.right);
        
        if(left!=null){
            left.right=node.right;
            node.right=node.left;
            node.left=null;
        }
//         else {
//             node.left=right;
//             node.right=null;
//         }
        
        if(right==null && left==null) return node;
        if(right==null) return left;
        return right;
        
    }
}