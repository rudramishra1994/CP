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
    public ListNode sortList(ListNode head) {
        ListNode tail = head;
        List<Integer> val = new ArrayList<>();
        while(tail!=null){
            val.add(tail.val);
            tail = tail.next;
        }
        tail = head;
        Collections.sort(val);
        for(int i : val){
            tail.val = i;
            tail = tail.next;
        }

        return head;
    }
}