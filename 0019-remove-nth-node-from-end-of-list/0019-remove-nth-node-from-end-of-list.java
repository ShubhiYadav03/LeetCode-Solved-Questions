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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode, slow = head, fast = head;
        
        while(n != 0 && fast != null){
            fast = fast.next;
            n--;
        }
        
        while(fast != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        
        prev.next = slow.next;
        
        return dummyNode.next;
    }
}