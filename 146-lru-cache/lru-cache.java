class LRUCache {

    int len;
    Map<Integer , Integer> map;
    Queue<Integer> q;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        q = new LinkedList<>();
        len = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        q.remove(key);
        q.add(key);
        return map.get(key);
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            q.remove(key);
            q.add(key);
            map.put(key , value);
        }
        else{
            if(q.size() == len){
                int k = q.poll();
                map.remove(k);
            }
            q.add(key);
            map.put(key , value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */