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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode head : lists){
            while(head!=null) {
                ListNode temp = head.next;
                head.next = null;
                queue.add(head);
                head = temp;
            }
        }
        ListNode head = queue.poll();
        ListNode tail = head;
        while(!queue.isEmpty()){
            tail.next = queue.poll();
            tail = tail.next;
        }
        return head;
    }
}