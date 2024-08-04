class MyHashSet {
    int size = 1000032;
    int[] hashSet;
    public MyHashSet() {
        hashSet = new int[size / 32];
    }
    
    public void add(int key) {
        hashSet[getIdx(key)] |= getMask(key);
    }
    
    public void remove(int key) {
        hashSet[getIdx(key)] &= (~getMask(key));
    }
    
    public boolean contains(int key) {
        return (hashSet[getIdx(key)]&getMask(key)) != 0;
    }

    private int getIdx(int key){
        return key / 32;
    }

    private int getMask(int key){
        key %= 32;
        return (1 << key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */