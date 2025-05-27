class Solution {
        public List<String> stringMatching(String[] words) {
             Arrays.sort(words);
	        ArrayList<String> ans = new ArrayList<>();
	        for (int i = 0; i < words.length; i++) {
	            String str = words[i];
	            for (int j = 0; j < words.length; j++) {
	                String big = words[j];
	                if (big.contains(str) && !str.equals(big) && !ans.contains(str)) {
	                	ans.add(str);
	                }

	            }

	            

	        }
	        return ans;
        }
}