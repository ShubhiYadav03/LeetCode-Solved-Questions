/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        
        Map<Node, Node> map = new HashMap();
        Node newNode = new Node(head.val);
        map.put(head, newNode);
        
        Node temp = head, node = newNode;
        while(temp != null){
            if(map.containsKey(temp.next)) node.next = map.get(temp.next);
            else{
                Node nextNode = (temp.next != null) ? new Node(temp.next.val) : null;
                node.next = nextNode;
                map.put(temp.next, nextNode);
            }
            if(map.containsKey(temp.random)) node.random = map.get(temp.random);
            else{
                Node randomNode = (temp.random != null) ? new Node(temp.random.val) : null;
                node.random = randomNode;
                map.put(temp.random, randomNode);
            }
            node = node.next;
            temp = temp.next;
        }
    
        return newNode;
    }
}