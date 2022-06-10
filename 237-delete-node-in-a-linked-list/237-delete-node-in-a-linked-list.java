/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode curr=node.next,prev=node;
        while(curr!=null){
            // int temp=curr.next;
            prev.val=curr.val;
            if(curr.next!=null) prev=curr;
            curr=curr.next;
        }
        
        prev.next=null;
        System.out.println(prev.val);
    }
}