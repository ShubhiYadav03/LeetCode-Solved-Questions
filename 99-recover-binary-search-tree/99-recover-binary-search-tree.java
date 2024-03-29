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
    TreeNode first = null, second = null, prev = null;
    public void recoverTree(TreeNode root) {
       // prev = new TreeNode(Integer.MIN_VALUE);
        recover(root);
        int temp = second.val;
        second.val = first.val;
        first.val = temp;
        
    }
    
    void recover(TreeNode root){
        if(root == null) return;

        recover(root.left);
        if(prev != null && root.val < prev.val){
            if(first == null) first = prev;
            second = root;
        }
        prev = root;
        recover(root.right);
    
    }
}