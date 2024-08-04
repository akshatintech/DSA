    class Node {
        public int key;
        public int val;
        public Node next;
        public Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            next = null;
            prev = null;
        }
    }

class LRUCache {
      private Map<Integer , Node> map;      //Will store the address of the Node to get the element in O(1)
        private Node head;
        private Node tail;
        private int size;
    public LRUCache(int capacity) {
      size = capacity;
      map = new HashMap<>();
      head = new Node(-1 , -1);
    tail = new Node(-1 , -1);
    head.next = tail;
    tail.prev = head;

    }

    private void deleteNode(Node p){
        Node pre = p.prev;
        Node nex = p.next;
        pre.next = nex;
        nex.prev= pre;
    }

    private void addNode(Node newNode){
        Node temp = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = temp;
        temp.prev = newNode;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node p = map.get(key);
        deleteNode(p);
        addNode(p);
        map.put(key , head.next);
        return head.next.val;

    }

    public void put(int key, int value) {

        if(map.containsKey(key)){
            Node c = map.get(key);
            deleteNode(c);          //Remove the old version if it already exists 
            c.val = value;          //update the value
            addNode(c);             //ADd the node so we do noot change the Least Frequently Used Mechanism
            map.put(key , head.next);
        }
        else{
            if(map.size() == size){
                Node prev = tail.prev;
                deleteNode(prev);
                Node l = new Node(key , value);
                addNode(l);
                map.remove(prev.key);
                map.put(key , head.next);
            }else{
                Node l = new Node(key , value);
                addNode(l);
                map.put(key , head.next);
            }
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */