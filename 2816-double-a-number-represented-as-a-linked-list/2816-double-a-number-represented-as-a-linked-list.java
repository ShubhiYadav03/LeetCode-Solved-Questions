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
    public ListNode doubleIt(ListNode head) {
        if(head == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode prev = dummyHead, curr = head;
        while(curr != null){
            int num = 2 * curr.val;
            if(num / 10 != 0) prev.val += 1;
            curr.val = num % 10;
            
            prev = curr;
            curr = curr.next;
        }
        
        return (dummyHead.val != 0) ? dummyHead : dummyHead.next;
    }
}