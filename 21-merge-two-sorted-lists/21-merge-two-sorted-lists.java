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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null) return null;
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode temp1=l1,temp2=l2;
        ListNode node=new ListNode();
        ListNode temp=node;
        while(temp1!=null && temp2!=null){
            temp.next=new ListNode();
            temp=temp.next;
            if(temp1.val<=temp2.val){
                temp.val=temp1.val;
                temp1=temp1.next;
            }
            else{
                temp.val=temp2.val;
                temp2=temp2.next;
            }
        }
        
        if(temp1!=null) temp.next=temp1;
        if(temp2!=null) temp.next=temp2;
        
        return node.next;
    }
}