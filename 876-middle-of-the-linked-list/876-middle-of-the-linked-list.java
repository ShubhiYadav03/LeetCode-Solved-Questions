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
    public ListNode middleNode(ListNode head) {
        int count=1;
        ListNode temp=head;
        while(temp.next!=null){
            count++;
            temp=temp.next;
        }
        if(count==1) return head;
        temp=head;
        for(int i=1;i<=count/2;i++){
            temp=temp.next;
        }
        
        //if(count%2==1)
            return temp;
        // else return temp.next;
    }
}