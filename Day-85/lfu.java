/**
 * Problem: LFU Cache (LeetCode #460)
 * Date: 23-09-2026
 *
 * ------------------------------------------------------------
 * Approach: HashMap + Frequency Map + Doubly Linked List
 *
 * Time Complexity:
 * get() -> O(1) average
 * put() -> O(1) average
 *
 * Space Complexity:
 * O(capacity)
 *
 * ------------------------------------------------------------
 */

class DLLNode {
    int key, val, freq;
    DLLNode prev, next;

    public DLLNode(int k, int v) {
        key = k;
        val = v;
        freq = 1;
    }
}

class DoubleLinkedList {
    int listSize;
    DLLNode head;
    DLLNode tail;

    public DoubleLinkedList() {
        this.listSize = 0;

        // Dummy head and tail nodes.
        this.head = new DLLNode(-1, -1);
        this.tail = new DLLNode(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    // Add node immediately after head.
    // This makes it the Most Recently Used node
    // within the current frequency.
    public void addNode(DLLNode currNode) {
        DLLNode frontNode = head.next;

        head.next = currNode;
        currNode.prev = head;

        currNode.next = frontNode;
        frontNode.prev = currNode;

        listSize++;
    }

    // Remove a node from the current frequency list.
    public void removeNode(DLLNode currNode) {
        DLLNode prevNode = currNode.prev;
        DLLNode frontNode = currNode.next;

        prevNode.next = frontNode;
        frontNode.prev = prevNode;

        currNode.next = null;
        currNode.prev = null;

        listSize--;
    }
}

class LFUCache {
    final int capacity;
    int currSize, minFreq;

    // key -> node
    Map<Integer, DLLNode> cache;

    // frequency -> doubly linked list
    Map<Integer, DoubleLinkedList> freqMap;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.currSize = 0;
        this.minFreq = 0;

        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        DLLNode currNode = cache.get(key);

        if(currNode == null) {
            return -1;
        }

        // Accessing a node increases its frequency.
        updateNode(currNode);

        return currNode.val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;

        if(cache.containsKey(key)) {

            // Update existing value.
            DLLNode currNode = cache.get(key);
            currNode.val = value;

            // Updating an existing node also increases
            // its frequency.
            updateNode(currNode);
        }
        else {
            currSize++;

            if(currSize > capacity) {

                // Cache is full.
                // Get the list corresponding to minimum frequency.
                DoubleLinkedList minFreqList = freqMap.get(minFreq);

                // The least recently used node is at the end
                // of the minimum-frequency list.
                DLLNode nodeToRemove = minFreqList.tail.prev;

                // Remove from HashMap.
                cache.remove(nodeToRemove.key);

                // Remove from frequency list.
                minFreqList.removeNode(nodeToRemove);

                currSize--;
            }

            // New node always starts with frequency 1.
            minFreq = 1;

            DLLNode newNode = new DLLNode(key, value);

            DoubleLinkedList currList =
                freqMap.getOrDefault(1, new DoubleLinkedList());

            // Insert new node at the front.
            currList.addNode(newNode);

            freqMap.put(1, currList);

            cache.put(key, newNode);
        }
    }

    public void updateNode(DLLNode currNode) {

        int currFreq = currNode.freq;

        // Get the list containing the current node.
        DoubleLinkedList currList = freqMap.get(currFreq);

        // Remove it from the old frequency list.
        currList.removeNode(currNode);

        // If this was the minimum-frequency list and it is
        // now empty, increase minFreq.
        if(currFreq == minFreq && currList.listSize == 0) {
            minFreq++;
        }

        // Increase node's frequency.
        currNode.freq++;

        // Get/create the list for the new frequency.
        DoubleLinkedList newList =
            freqMap.getOrDefault(currNode.freq, new DoubleLinkedList());

        // Add node at the front of the new frequency list.
        newList.addNode(currNode);

        freqMap.put(currNode.freq, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */