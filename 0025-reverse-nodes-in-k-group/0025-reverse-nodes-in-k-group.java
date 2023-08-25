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

        int countNodes = 0;
        ListNode tail = head;
        while(tail!=null) {
            countNodes++;
            tail = tail.next;
        }
        int grpCount = countNodes/k;
        if(grpCount == 0) return head;
        int count = 0; int member = 1 ;
        ListNode curr = head, prev =null,next = curr.next,prefix = null,resHead = null;
        tail = curr;
        while(count < grpCount && curr!=null){
            while(member <= k){
                curr.next = prev;
                prev = curr;
                curr = next;
                member++;
                if(curr!=null)
                next = curr.next;
            }
            if(member >k) {
                count++;
                member = 1;
            }
            if(prefix!=null) {
                prefix.next = prev;
                prefix = tail;
            }
            if(count == 1){
                resHead = prev;
                prefix = tail;
            }
            prev = null;
            tail = curr;
            if(count == grpCount && prefix !=null){
                prefix.next = curr;
                break;
            }
        }

        return resHead;
    }
}