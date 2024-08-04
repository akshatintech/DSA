class WordDictionary {
    // 1. Create a ArrayList to store each String
    
    ArrayList<String> arr;
    HashSet<String> set;
    public WordDictionary() {
        arr = new ArrayList<>();
        set = new HashSet<>();
    }
    
    public void addWord(String word) {
        if(!set.contains(word)){
            set.add(word);
            arr.add(word);
        }
    }
    
    public boolean search(String word) {
        if (set.contains(word)) {
            return true;
        }

        for (String s : arr) {
            if (s.length() == word.length() && matches(s, word)) {
                return true;
            }
        }

        return false;
    }
    private boolean matches(String s, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != '.' && word.charAt(i) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */