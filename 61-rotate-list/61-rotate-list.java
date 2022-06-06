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
        k=k%(size+1);
        while(k>0){    
            
            ListNode temp2=head, temp3=null;
            for(int i=0;i<size-1;i++){
                temp2=temp2.next;     
            }
            temp3=temp2.next;
            temp3.next=head;
            temp2.next=null;
            head=temp3;
            
            System.out.println(temp.val);
            System.out.println(temp2.val);
            k--;
        }
        
        return head;
    }
}