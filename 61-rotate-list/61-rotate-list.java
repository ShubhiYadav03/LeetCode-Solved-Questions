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
        if(head == null) return null;
        ListNode temp=head;
        int size=0;
        while(temp.next!=null){
                size++;
                temp=temp.next;            
            }
        temp.next=head;
        k=k%(size+1);       
            ListNode temp2=head, temp3=null;
            for(int i=0;i<size-k;i++){
                temp2=temp2.next;     
            }
            temp3=temp2.next;
            temp2.next=null;
            head=temp3;

        return head;
    }
}