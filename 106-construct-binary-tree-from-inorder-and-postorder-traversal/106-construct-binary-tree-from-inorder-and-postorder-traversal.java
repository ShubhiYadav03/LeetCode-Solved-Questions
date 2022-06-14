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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return tree(inorder, 0,inorder.length-1,postorder,0,postorder.length-1,map);
    }
    TreeNode tree(int[] inorder,int inStart,int inEnd, int[] postorder,int postStart,int postEnd, Map<Integer,Integer> map){
        if(postEnd<postStart || inStart>inEnd) return null;
        
        TreeNode root=new TreeNode(postorder[postEnd]);
        
        int inRoot=map.get(root.val);
        int numsLeft=inRoot-inStart;
        
        root.left=tree(inorder,inStart,inRoot-1,postorder,postStart,postStart+numsLeft-1,map);
        root.right=tree(inorder,inRoot+1,inEnd,postorder,postStart+numsLeft,postEnd-1,map);
        
        return root;
    }
}