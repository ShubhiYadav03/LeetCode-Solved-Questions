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
    int idx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        // TreeNode root = new TreeNode(preorder[0]);
        
        return createBST(preorder, Integer.MAX_VALUE);
    }
    
    TreeNode createBST(int[] preorder, int bound){
        if(idx == preorder.length || preorder[idx] > bound) return null;
        
        TreeNode node = new TreeNode(preorder[idx++]);
        
        node.left = createBST(preorder, node.val);
        node.right = createBST(preorder, bound);
        
        return node;
    }
}