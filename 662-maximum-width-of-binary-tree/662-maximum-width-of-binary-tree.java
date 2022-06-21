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
class Pair{
    int idx;
    TreeNode node;
    Pair(TreeNode node,int i){
        this.node=node;
        this.idx=i;
        
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> q=new ArrayDeque();
        q.add(new Pair(root,0));
        int width=0;
        while(!q.isEmpty()){
            int len=q.size();
            int min=q.peek().idx;
            int first=0,last=0;
            
            for(int i=0;i<len;i++){
                Pair p=q.poll();
                TreeNode temp=p.node;
                int idx=p.idx-min;
                if(i==0) first=idx;
                if(i==len-1) last=idx;
                if(temp.left!=null) q.add(new Pair(temp.left,idx*2+1));
                if(temp.right!=null) q.add(new Pair(temp.right,idx*2+2));
            }
            width=Math.max(last-first+1,width);
        }
        
        return width;
    }
}