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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        
        ListNode dummySmall = new ListNode(-101);
        dummySmall.next = head;
        ListNode dummyBig = new ListNode(-101);
        dummyBig.next = head;
        
        ListNode small = dummySmall, big = dummyBig, curr = head;
        
        while(curr != null){
            if(curr.val < x){
                small.next = curr;
                small = curr;
                curr = curr.next;
            }else{
                big.next = curr;
                big = curr;
                curr = curr.next;
            }
            
        }
        
        
        if(dummyBig.next.val >= x) small.next = dummyBig.next;
        big.next = null;
        return dummySmall.next;
    }
}