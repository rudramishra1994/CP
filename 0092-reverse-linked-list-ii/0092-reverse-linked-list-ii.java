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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        int count = 1 ;
        ListNode leftHalf = null;
        if(left == 1){
            leftHalf = null;
            ListNode prev = null;
            ListNode curr = head;
            ListNode tail = head;
            ListNode next = curr.next;
            while(count <= right){
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
                if(curr!=null)
                next = curr.next;
            }
            tail.next = curr;
            return prev;

        } else {
            leftHalf = head;
            while(count++< left - 1){
                leftHalf = leftHalf.next;
            }
            ListNode prev = null;
            ListNode curr = leftHalf.next;
            ListNode tail = leftHalf.next;
            ListNode next = curr.next;
            while(count <= right){
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
                if(curr!=null)
                next = curr.next;
            }
            tail.next = curr;
            leftHalf.next = prev;
            return head;
        }

    }


}