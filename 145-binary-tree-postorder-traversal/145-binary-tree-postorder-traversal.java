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
    public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> list=new ArrayList<Integer>();
        //list.add(root.val);
        postorder(root,list);
        
        return list;
    }
    
    void postorder(TreeNode node,List<Integer> list){
        if(node==null) return;

        postorder(node.left,list);
        postorder(node.right,list);
        list.add(node.val);
    }
}