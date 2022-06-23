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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode prev=dummy,curr1=head,curr2=head.next;
        
        while(curr1!=null && curr2!=null){
            ListNode temp = curr2.next;
            prev.next=curr2;
            curr1.next=temp;
            curr2.next=curr1;
            prev=curr1;
            if(temp!=null) curr2=temp.next;
            curr1=temp;
            
        }
        return dummy.next;
    }
}