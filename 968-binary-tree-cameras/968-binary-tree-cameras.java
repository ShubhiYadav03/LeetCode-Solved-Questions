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
    int sum=0;
    public int minCameraCover(TreeNode root) {
        if(camera(root)==0) sum++;
        return sum;
    }
    int camera(TreeNode root){
        if(root==null) return 1;
        
        int left=camera(root.left);
        int right=camera(root.right);
        
        if(left==0 || right==0){
            sum++;
            return 2;
        }
        if(left==1 && right==1) return 0;
        
        if(left==2 || right==2) return 1;
        sum++;
        return 2;
    }
}