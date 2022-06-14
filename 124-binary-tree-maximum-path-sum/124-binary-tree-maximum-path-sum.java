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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }
    int maxSum(TreeNode node){
        if(node==null) return 0;
        
        int left=maxSum(node.left);
        int right = maxSum(node.right);
        
        int max1=Math.max(left+right+node.val,Math.max(left+node.val,right+node.val));
        max=Math.max(max,Math.max(node.val,max1));
        
        return Math.max(0,Math.max(left,right))+node.val;
    }
}