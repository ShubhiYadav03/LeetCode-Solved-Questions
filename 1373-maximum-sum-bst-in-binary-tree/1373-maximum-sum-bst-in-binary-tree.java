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
class NodeVal{
    int sum;
    int minNode;
    int maxNode;
    
    NodeVal(int sum,int minNode,int maxNode){
        this.sum=sum;
        this.minNode=minNode;
        this.maxNode=maxNode;
    }
}

class Solution {
    
    public int maxSumBST(TreeNode root) {
        sumBST(root);
        return maxSum;
    }
    int maxSum=0;
    NodeVal sumBST(TreeNode root){
        if(root == null){
            return new NodeVal(0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        
        NodeVal left=sumBST(root.left);
        NodeVal right=sumBST(root.right);
        
        if(left.maxNode<root.val && right.minNode>root.val){
            maxSum = Math.max(maxSum, root.val + left.sum + right.sum);
            return new NodeVal(root.val + left.sum + right.sum,Math.min(root.val, left.minNode), Math.max(root.val, right.maxNode));
        }
        
        return new NodeVal(Math.max(left.sum,right.sum),Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}