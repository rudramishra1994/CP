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
        ListNode l  = head, r = head;
        int count = 1;
        while( count < n+1){
            r =r.next;
            count++;
        }
        if(r == null) return head.next;
        while(r.next!=null){
            l = l.next;
            r = r.next; 
        }
        l.next = l.next.next;
        return head;
    }

}