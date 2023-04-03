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
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList();
        findSum(root, targetSum, list);
        // List<List<Integer>> res = new ArrayList();
        
        
        // for(List<Integer> li : ans){
        //     if(li.size() > 0) res.add(li);
        // }
        return ans;
    }
    
    void findSum(TreeNode node, int targetSum, List<Integer> list){
        if(node != null && node.left == null && node.right == null && targetSum == node.val){
            list.add(node.val);
            ans.add(new ArrayList(list));
            list.remove(list.size() - 1);
            return;
        }
        if(node == null){
            return;
        }
        
        
        list.add(node.val);
        findSum(node.left, targetSum - node.val, list);
        findSum(node.right, targetSum - node.val, list);
        list.remove(list.size() - 1);
        
    }
}