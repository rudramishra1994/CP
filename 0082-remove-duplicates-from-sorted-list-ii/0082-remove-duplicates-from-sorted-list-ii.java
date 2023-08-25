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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode sentinel = new ListNode(-1000,head);
        ListNode left = sentinel;
        ListNode prev = head;
        ListNode curr = head.next;
        int count = 1;
        while(curr!=null){
            if(curr.val == prev.val) count++;
            else{
                if(count ==1){
                    left.next = prev;
                    left = prev;
                }
                prev = curr;
                count = 1;
                
            }

            curr = curr.next;
            if(curr == null && count ==1) left.next = prev;
            else if(curr == null && count > 1) left.next = null; 
        }
        return sentinel.next;
       
    }
}