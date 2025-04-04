class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String , List<String>> map = new HashMap<>();
        for(int i = 0;i < strs.length;i++){
            String word = strs[i];
            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            String sorted_word = new String(chars);
            if(!map.containsKey(sorted_word)){
                map.put(sorted_word , new ArrayList<>());
            }

            map.get(sorted_word).add(word);
        }
        return new ArrayList<>(map.values());
    }
}