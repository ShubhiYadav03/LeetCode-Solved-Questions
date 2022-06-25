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
    
    TreeNode parent1=null, parent2=null;
    int depth1=0, depth2=0;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || x == root.val || y == root.val) return false;
        cousins(root,x,y,0);
        return (parent1 != parent2) && (depth1 == depth2);
    }
    
    void cousins(TreeNode root, int x, int y, int depth){
        if(root==null) return;
        
        if((root.left != null && root.left.val == x) || (root.right != null && root.right.val == x)){
            parent1 = root;
            depth1 = depth;
        } 
        if((root.left != null && root.left.val == y) || (root.right != null && root.right.val == y)){
            parent2 = root;
            depth2 = depth;
        } 
        
        cousins(root.left,x,y,depth+1);
        cousins(root.right,x,y,depth+1);
        
    }
}