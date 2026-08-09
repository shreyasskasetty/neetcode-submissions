
class Node{
    int val;
    int key;
    Node next;
    Node prev;
    Node(){

    }
    Node(int val){
        this.val = val;
    }
    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
    public void setValue(int val){
        this.val = val;
    }
}

class LRUCache {
    int capacity;
    HashMap<Integer, Node> cache;
    Node head;
    Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        this.head.next = tail;
        this.tail.prev = head;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    private int removeFirst() { // evict head.next (LRU)
        Node lru = head.next;
        if (lru == tail) return -1; // empty
        int removedKey = lru.key;
        removeNode(lru);
        return removedKey;
    }

    private void addLast(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            removeNode(node);
            addLast(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) return;
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.setValue(value);
            removeNode(node);
            addLast(node);
            return;
        }
        if (cache.size() >= capacity) {
            int lruKey = removeFirst();
            cache.remove(lruKey);
        }
        Node node = new Node(key, value);
        addLast(node);
        cache.put(key, node);
    }
}
