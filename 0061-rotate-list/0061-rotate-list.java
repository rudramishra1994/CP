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
        int count  = 0;
        if(head ==null) return head;
        ListNode tail = head;
        ListNode l = null;
        while(tail != null){
            if(tail.next == null) l = tail;
            tail = tail.next;
            count++;
        }
        k = k % count;
        tail = head;
        if( k == 0) return head;
        int n = 0;
        while( ++n < count-k){
            tail = tail.next;
        }
        ListNode h = tail.next;
        tail.next = null;
        l.next = head;
        return h;

    }
}