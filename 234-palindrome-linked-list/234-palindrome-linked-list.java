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
    public boolean isPalindrome(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while(f.next!=null && f.next.next!=null){
            s=s.next;
            f=f.next.next;
        }
        s.next = reverse(s.next);
        s = s.next;
        
        while(s!=null){
            if(head.val != s.val) return false;
            s = s.next;
            head = head.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode temp = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = temp;
            temp = head;
            head = next;
        }
        return temp;
    }
}