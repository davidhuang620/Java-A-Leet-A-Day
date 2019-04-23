class LRUCache {
    
    class Node {
        int key;
        int value;
        Node next;
        Node prev;
        Node (int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    Node root;
    Node tail;
    int cap;
    int size = 0;
    HashMap<Integer, Node> map = new HashMap<>();
    
    public LRUCache(int capacity) {
        root = new Node(-1, -1);
        tail = new Node(-2, -2);
        root.next = tail;
        tail.prev = root;
        cap = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insertInFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (get(key) != -1){
            map.get(key).value = value;
            return;
        }
        Node node = new Node(key, value);
        insertInFront(node);
        size++;
        
        if (size > cap){
            remove(tail.prev);
            size--;
        }
    }
    
    private void insertInFront(Node node){
        
        node.next = root.next;
        node.prev = root;
        
        root.next = node;
        node.next.prev = node;
        
        map.put(node.key, node);
    }
    
    private void remove(Node node){
        
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
        map.remove(node.key);
    }
    
}
