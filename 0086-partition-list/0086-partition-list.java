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
    public ListNode partition(ListNode head, int x) {
        if(head ==null) return head;
        ListNode sentinel = new ListNode(1000,head);
        ListNode prev = sentinel,prefix = sentinel,curr = head;
        boolean seen = false;
        while(curr !=null){
            if(curr.val < x && !seen){
                prev = curr;
                prefix = prev;
                curr = curr.next;
            }else if(curr.val < x && seen){
                prev.next = curr.next;
                curr.next = prefix.next;
                prefix.next = curr;
                prefix = curr;
                curr = prev.next;
            }else if(curr.val >=x){
                seen = true;
                prev = curr;
                curr = curr.next;
            }
        }
        return sentinel.next;
    }
}