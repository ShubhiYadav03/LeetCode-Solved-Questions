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
        List<List<Integer>> list=new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> q=new ArrayDeque<>();
        q.add(root);
        int flag=0;
        while(!q.isEmpty()){
            int qLen=q.size();
            List<Integer> li=new ArrayList<>();
            for(int i=0;i<qLen;i++){
                TreeNode node=q.poll();
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
                li.add(node.val);
            }
            if(flag==0){
                list.add(li);
                flag=1;
            }else{
                Collections.reverse(li);
                list.add(li);
                flag=0;
            }
        }
        
        return list;
    }
}