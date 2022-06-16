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
    public int goodNodes(TreeNode root) {
        return good(root,root.val);
    }
    int good(TreeNode node,int val){
        if(node==null) return 0;
        
        int left=good(node.left,Math.max(val,node.val));
        int right=good(node.right,Math.max(val,node.val));
        int ans=left+right;
        if(node.val>=val) ans+=1;
        return ans;
    }
}