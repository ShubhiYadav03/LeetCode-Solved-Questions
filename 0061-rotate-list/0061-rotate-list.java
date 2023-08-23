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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
     
        ListNode fast = head, slow = head;
        int len = 1;
        while(fast.next != null){
            len++;
            fast = fast.next;
        }
        
        len -= k % len;
        
        while(len != 1){
            len--;
            slow = slow.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;
        
        return head;
    }
}