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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 =  new ListNode(0);
        ListNode head = l3;
        int carry = 0;
        while(l1!=null || l2!=null || carry > 0){
            int val = (l1 ==null ? 0 : l1.val) + (l2 == null? 0 : l2.val) + carry;
            carry = val/10;
            if(l1!=null)l1= l1.next;
            if(l2!=null)l2 =l2.next;
            l3.next = new ListNode(val%10);
            l3 = l3.next;
        }
        return head.next;


    }
}