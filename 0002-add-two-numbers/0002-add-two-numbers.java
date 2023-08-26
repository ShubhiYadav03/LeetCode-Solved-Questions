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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode temp1 = l1, temp2 = l2, newHead = dummyHead;
        int carry = 0;
        while(temp1 != null && temp2 != null){
            int sum = temp1.val + temp2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            newHead.next = new ListNode(sum);
            
            temp1 = temp1.next;
            temp2 = temp2.next;
            newHead = newHead.next;
        }
        
        if(temp1 == null && temp2 != null) temp1 = temp2;
        while(temp1 != null){
            int sum = temp1.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            newHead.next = new ListNode(sum);
            
            temp1 = temp1.next;
            newHead = newHead.next;
        }
        
        if(carry != 0) newHead.next = new ListNode(carry);
    
        return dummyHead.next;
    }
}