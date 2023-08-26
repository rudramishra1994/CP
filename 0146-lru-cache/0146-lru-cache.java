class LRUCache {
    private int capacity ; 
    private Map<Integer,ListNode> map;
    private ListNode head;
    private ListNode tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1,-1);
        tail = new ListNode(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
       if(!map.containsKey(key)) return -1;
       else{
            ListNode node = map.get(key);
            remove(node);
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
            return node.val;
       }

       
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            map.get(key).val = value;
            ListNode node = map.get(key);
            remove(node);
            add(node);
            
        }
        else{
            ListNode node = new ListNode(key,value);
            map.put(key,node);
            add(node);
        }
        if(map.size()>capacity){
        System.out.print(head.next.val);
            map.remove(head.next.key);
           remove(head.next);
           
        }
    }

    private void remove(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void add(ListNode node){
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    private static class ListNode{
        public int key;
        public int val;
        public ListNode next;
        public ListNode prev;
        ListNode(){
            next = null;
            prev = null;
        }
        ListNode(int key,int val){
            this.key = key;
            this.val = val;
            next = null;
            prev = null;
        }
    }
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */