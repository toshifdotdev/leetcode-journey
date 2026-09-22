/**
 * Problem: LRU Cache (LeetCode #146)
 * Date: 22-09-2026
 *
 * ------------------------------------------------------------
 * Approach: HashMap + Doubly Linked List
 * ------------------------------------------------------------
 *
 * Observation:
 *
 * HashMap gives fast access to the node:
 *
 *     key -> Node
 *
 * Doubly Linked List gives O(1) insertion and deletion because
 * every node has both prev and next references.
 *
 * Combining both gives O(1) get() and O(1) put().
 *
 * ------------------------------------------------------------
 *
 * Example:
 *
 * capacity = 2
 *
 * put(1, 1)
 * put(2, 2)
 *
 * List:
 * head -> 2 -> 1 -> tail
 *
 * get(1)
 *
 * Node 1 becomes recently used:
 *
 * head -> 1 -> 2 -> tail
 *
 * put(3, 3)
 *
 * Cache is full, so node 2 (LRU) is removed:
 *
 * head -> 3 -> 1 -> tail
 *
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * get() -> O(1)
 * put() -> O(1)
 *
 * Space Complexity:
 * O(capacity)
 *
 * ------------------------------------------------------------
 */

class Node {
    int key, val;
    Node prev, next;

    Node(int k, int v) {
        key = k;
        val = v;
    }
}

class LRUCache {
    HashMap<Integer, Node> hm = new HashMap<>();
    int capacity;
    Node head, tail;

    // Removes a node from its current position.
    void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    // Inserts a node immediately after the dummy head.
    // This makes it the Most Recently Used node.
    void insertAfterHead(Node node) {
        Node nextNode = head.next;
        head.next = node;
        node.prev = head;

        node.next = nextNode;
        nextNode.prev = node;
    }

    public LRUCache(int capacity) {
        // Dummy head and tail nodes.
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;

        head.prev = null;
        tail.next = null;

        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!hm.containsKey(key)) return -1;

        Node node = hm.get(key);

        // Move accessed node to the front because
        // it is now the Most Recently Used node.
        deleteNode(node);
        insertAfterHead(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)) {

            // Update existing value.
            Node node = hm.get(key);
            node.val = value;

            // Existing node becomes Most Recently Used.
            deleteNode(node);
            insertAfterHead(node);
        }
        else {
            if(hm.size() == capacity) {

                // Remove Least Recently Used node.
                Node node = tail.prev;

                // Remove its key from the HashMap.
                hm.remove(node.key);

                deleteNode(node);
            }

            // Insert new node as Most Recently Used.
            Node newNode = new Node(key, value);
            hm.put(key, newNode);
            insertAfterHead(newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */