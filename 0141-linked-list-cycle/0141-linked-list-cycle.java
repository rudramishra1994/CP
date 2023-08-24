/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(head == null) return false;

        while(fast !=null){
            slow = slow.next;
            if(fast.next!=null) fast = fast.next.next;
            else return false;
            if(fast==slow) return true;
        }

        return false;
    }
}