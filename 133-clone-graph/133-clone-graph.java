/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        HashMap<Integer, Node> visited = new HashMap<>();
        return dfs(node, visited);
        
    }
    
    Node dfs(Node node, HashMap<Integer, Node> visited){
        //if(node == null) return null;
        if(visited.containsKey(node)) return visited.get(node);
        Node newNode = new Node(node.val);
        visited.put(node.val, newNode);
        
        for(Node n : node.neighbors){
            if(!visited.containsKey(n.val))
                newNode.neighbors.add(dfs(n, visited));
            else newNode.neighbors.add(visited.get(n.val));
        }
        
        return newNode;
    }
}