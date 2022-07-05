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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode left = head;
        ListNode right = getMid(head);
        ListNode temp = right.next;
        right.next = null;
 
        left = sortList(left);
        right = sortList(temp);
        
        return merge(left, right);
    }
    
    ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(left != null && right != null){
            if(left.val <= right.val){
                tail.next = left;
                left = left.next;
            }
            else{
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        if(left != null) tail.next = left;
        else if(right != null) tail.next = right;
        
        return dummy.next;  
    }
    
    ListNode getMid(ListNode head){
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}