class RandomizedSet {
    Set<Integer> s;
    List<Integer> arr;
    public RandomizedSet() {
        s = new HashSet<>();
        arr = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (!s.contains(val)) {
            s.add(val);
            arr.add(val);
            return true;
        }
        return false;
    }
    public boolean remove(int val) {
        if (s.contains(val)) {
            s.remove(val);
            arr.remove((Integer)val);
            return true;
        }
        return false;
    }  
    public int getRandom() {
        int n = arr.size();
        int rnd = (int)(Math.random() * n);
        return arr.get(rnd);
    }
}