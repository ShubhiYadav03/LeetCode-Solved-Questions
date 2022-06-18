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
    public String serialize(TreeNode root) {
            StringBuilder stringBuilder = new StringBuilder();
        preOrder(root, stringBuilder);
        return stringBuilder.toString();
    }

    public void preOrder(TreeNode root, StringBuilder stringBuilder){
        if(root == null){
            stringBuilder.append("#").append(',');
            return;
        }
        stringBuilder.append(String.valueOf(root.val)).append(',');
        preOrder(root.left, stringBuilder);
        preOrder(root.right, stringBuilder);
        return;
    }

    // Decodes your encoded data to tree.

    int pointer;
    public TreeNode deserialize(String data) {
        System.out.println(data);
        pointer = 0;
        String[] strings = data.split(",");
        return preOrderDecode(strings);
    }

    public TreeNode preOrderDecode(String[] encString){
        if(encString[pointer].equalsIgnoreCase("#")){
            pointer++;
            return null;
        }
        TreeNode cur = new TreeNode(Integer.valueOf(encString[pointer++]));
        cur.left = preOrderDecode(encString);
        cur.right = preOrderDecode(encString);
        return cur;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));