/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ser=new StringBuilder("");
        dfs(root,ser);
        return ser.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str=data.split(",");
        TreeNode node=new TreeNode();
        System.out.println(Arrays.toString(str));
        return decode(str);
    }
    int i=0;
    TreeNode decode(String[] ch){
        //if(i>=ch.length) return null;
        if(ch[i].equals("N")){
            i++;
            return null;
        }
        TreeNode node=new TreeNode(Integer.valueOf(ch[i++]));
        // int num=;
        // node.val=num-48;
        //i++;
        node.left=decode(ch);
        node.right=decode(ch);
        
        return node;
    }
    
    void dfs(TreeNode root,StringBuilder ser){
        if(root==null) {
            ser.append("N").append(",");
            return;
        }
        ser.append(root.val).append(",");
        dfs(root.left,ser);
        dfs(root.right,ser);
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));