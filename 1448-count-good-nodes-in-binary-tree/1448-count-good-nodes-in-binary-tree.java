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
    int ans=0;
    public int goodNodes(TreeNode root) {
        good(root,root.val);
        return ans;
    }
    void good(TreeNode node,int val){
        if(node==null) return;
        
        good(node.left,Math.max(val,node.val));
        good(node.right,Math.max(val,node.val));
        
        if(node.val>=val) ans+=1;
        
    }
}