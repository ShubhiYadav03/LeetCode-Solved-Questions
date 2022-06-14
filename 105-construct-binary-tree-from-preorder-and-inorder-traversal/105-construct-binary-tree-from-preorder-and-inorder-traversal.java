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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hm=new HashMap();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
          return tree(0,preorder.length-1,preorder,0,inorder.length-1,inorder, hm);
    }
    TreeNode tree(int preStart,int preEnd,int[] preorder,int inStart,int inEnd, int[] inorder, HashMap<Integer,Integer> hm){
        if(preStart>preEnd || inStart>inEnd) return null;
        TreeNode root=new TreeNode(preorder[preStart]); 
        int inRoot=hm.get(root.val);
        int numsLeft=inRoot-inStart;
        root.left=tree(preStart+1,preStart+numsLeft,preorder,inStart,inRoot-1,inorder,hm);
        root.right=tree(preStart+numsLeft+1,preEnd,preorder,inRoot+1,inEnd,inorder,hm);
        
        return root;
    }
}