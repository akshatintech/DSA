class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
         if (pattern.length() != words.length) return false;
        HashMap<Character , String> map =new HashMap<>();
         HashSet<String> usedWords = new HashSet<>();
        for(int i = 0;i < pattern.length() ;i++){
            char ch = pattern.charAt(i);
            if (map.containsKey(ch)) {
                 if (!map.get(ch).equals(words[i])) {
                    return false;
                }
            }
            else{
                if (usedWords.contains(words[i])) {
                    return false; // same word assigned to multiple pattern chars
                }
                map.put(ch, words[i]);
                usedWords.add(words[i]);
            }
        }

        return true;
        
    }
}