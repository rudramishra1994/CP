/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node newHead = new Node(0);
        Node backupHead = head;
        Node newTail = newHead;
        Map<Node,Node> old_New = new HashMap<>();
        while(head!=null){
            old_New.put(head,newTail);
            newTail.val = head.val;
            if(head.next!=null)
                newTail.next = new Node(0);
            newTail = newTail.next;
            head = head.next;
        }
        Node tail = newHead;
        while(tail!=null){
                tail.random = old_New.get(backupHead.random);
                tail = tail.next;
                backupHead = backupHead.next;
        }
        return newHead;
    }
}