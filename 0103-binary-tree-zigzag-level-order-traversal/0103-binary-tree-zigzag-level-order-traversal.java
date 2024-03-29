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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        if(root == null) return ans;
        
        Queue<TreeNode> q = new ArrayDeque();
        q.add(root);
        boolean order = true;
        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> list = new ArrayList();
            for(int i = 0; i < len; i++){
                TreeNode node = q.remove();
                list.add(node.val);
            
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            
            if(!order) Collections.reverse(list);
            ans.add(list);
            order = !order;
        }
        
        return ans;
    }
}