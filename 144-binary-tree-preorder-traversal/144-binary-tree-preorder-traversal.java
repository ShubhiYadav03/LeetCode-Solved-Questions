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
    public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> list=new ArrayList<Integer>();
        //list.add(root.val);
        preorder(root,list);
        
        return list;
    }
    
    void preorder(TreeNode node,List<Integer> list){
        if(node==null) return;
        
        list.add(node.val);
        preorder(node.left,list);
        preorder(node.right,list);
    }
}