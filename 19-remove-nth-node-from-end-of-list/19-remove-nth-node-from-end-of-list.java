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
        if(head.next==null&&n==1) return head.next;
        int size=1;
        ListNode temp=head;
        while(temp.next!=null){
            size++;
            temp=temp.next;
        }
        if(size-n==0) return head.next;
        ListNode temp2=head;
        System.out.println(size);
        for(int i=1;i<size-n;i++){
            temp2=temp2.next;
        }
        
       // if(temp2==head) head=head.next;
        ListNode del=temp2.next.next;
        temp2.next=del;
       // if(temp2==head) head=head.next;
        return head;
    }
}