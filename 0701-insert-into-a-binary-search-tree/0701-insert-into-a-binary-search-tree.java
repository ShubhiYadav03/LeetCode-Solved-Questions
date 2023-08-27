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
    boolean inserted = false;
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(val < root.val && root.left == null){
            root.left = new TreeNode(val);
            return root;
        }
        if(val > root.val && root.right == null){
            root.right = new TreeNode(val);
            return root;
        }
        
        TreeNode node = root;
        while(node != null){
            if(node.val < val){
                if(node.right != null) node = node.right;
                else{
                    node.right = new TreeNode(val);
                    break;
                }
            }
            else{
                if(node.left != null) node = node.left;
                else{
                    node.left = new TreeNode(val);
                    break;
                }
            }
        }
        
        return root;
    }
    
    
}