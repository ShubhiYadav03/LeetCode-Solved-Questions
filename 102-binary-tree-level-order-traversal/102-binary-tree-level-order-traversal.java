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
    List<List<Integer>> list;
    public List<List<Integer>> levelOrder(TreeNode root) {      
        list = new ArrayList<>();       
        solve(0, root);
        return list;
    }
    
    public void solve(int height, TreeNode node){
        if(node==null){
            return;
        }
        
        if(list.size()<=height){
            list.add(new ArrayList<>());
        }
        
        list.get(height).add(node.val);
        
        solve(height+1, node.left);
        solve(height+1, node.right);
    }
}