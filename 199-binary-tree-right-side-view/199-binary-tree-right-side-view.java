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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        int currLevel=0;
        rightView(root,currLevel,list);
        return list;
    }
    void rightView(TreeNode node,int currLevel,List<Integer> list){
        if(node==null) return;
        
        if(currLevel==list.size()){
            list.add(node.val);
        }
        rightView(node.right,currLevel+1,list);
        rightView(node.left,currLevel+1,list);
    }
}