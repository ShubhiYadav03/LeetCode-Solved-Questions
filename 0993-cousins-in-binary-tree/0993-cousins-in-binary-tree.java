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
    TreeNode parentx = null, parenty = null;
    int heightx = 0, heighty = 0;
    public boolean isCousins(TreeNode root, int x, int y) {
        solve(root, x, y, 0);
        
        return parentx != parenty && heightx == heighty;
    }
    
    int solve(TreeNode node, int x, int y, int height){
        if(node == null) return 0;
        
        int left = solve(node.left, x, y, height + 1);
        int right = solve(node.right, x, y, height + 1);
        
        if(left == x){
            parentx = node;
            heightx = height + 1;
        }
        
        if(left == x || right == x){
            parentx = node;
            heightx = height + 1;
        }
        
        if(left == y || right == y){
            parenty = node;
            heighty = height + 1;
        }
        
        return node.val;
    }
}