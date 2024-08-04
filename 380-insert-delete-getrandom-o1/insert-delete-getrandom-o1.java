class RandomizedSet {
    ArrayList<Integer> list;
    HashMap<Integer , Integer> map;
    java.util.Random rand = new java.util.Random();
    public RandomizedSet() {
        list= new ArrayList<Integer>();
        map = new HashMap<Integer , Integer>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
        return false;
        }
        else{
            map.put(val , list.size());
            list.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int index= map.get(val);
        int lastElement = list.get(list.size() -1);

        //Swapping the element to be removed with the last element
        list.set(index , lastElement);
        map.put(lastElement , index);

        //Removing the last element
        list.remove(list.size() -1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */