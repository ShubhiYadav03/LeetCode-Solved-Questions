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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k<2) return head;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode curr=head, prev=dummy;
        while(curr!=null){
            Pair<ListNode,ListNode> p = reverse(prev,curr,k);
            curr=p.getValue();
            prev=p.getKey();
        }             
        return dummy.next;
    }
    
    Pair<ListNode,ListNode> reverse(ListNode prev, ListNode head, int k){
        int i=0;
        
        ListNode tail=null;
        while(i<k && head!=null){
            ListNode temp=head.next;
            head.next=tail;
            tail=head;
            head=temp;
            i++;
        }

        ListNode node=prev.next;
        node.next=head;
        prev.next=tail;
        
        if(i<k){
            return reverse(prev,tail,i);
        }

        return new Pair<ListNode,ListNode>(node,head);
          
    }
    
}