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
    int htx = 0, hty = 0;
    boolean sib = false;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0);
        
        return (sib) ? !sib : htx == hty;
    }
    
    void dfs(TreeNode node, int x, int y, int height){
        if(node == null) return;
        if((node.left != null && (node.left.val == x || node.left.val == y)) && (node.right != null && (node.right.val == y || node.right.val == x))){
            sib = true;
            return;
        }
        if(node.val == x) htx = height;
        if(node.val == y) hty = height;
        dfs(node.left, x, y, height + 1);
        dfs(node.right, x, y, height + 1);
    }
    
}