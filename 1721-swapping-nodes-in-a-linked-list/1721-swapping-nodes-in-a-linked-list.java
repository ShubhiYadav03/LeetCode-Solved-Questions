/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        
        ListNode prev = dummyNode, curr = head, prev1 = prev, prev2 = prev;
        ListNode node1 = null, node2 = null;
        
        int len = 0;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        if(k == len - k + 1) return head;
        curr = head;
        
        int i = 1;
        while(curr != null){
            if(i == k){
                prev1 = prev;
                node1 = curr;
            }
            if(i == len - k + 1){
                prev2 = prev;
                node2 = curr;
            }
            i++;
            prev = curr;
            curr = curr.next;
        }
        
        if(prev2 == node1){
            prev1.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            return dummyNode.next;
        }
        ListNode temp = node1.next;
        prev1.next = node2;
        prev2.next = node1;
        node1.next = node2.next;
        node2.next = temp;
        return dummyNode.next;
    }
}