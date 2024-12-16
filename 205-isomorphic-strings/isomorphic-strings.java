class Solution {
    public boolean isIsomorphic(String s, String t) {
        
		int[] indexS = new int[200];		//Stroes
		int[] indexT = new int[200];
		
		
		int len = s.length();
		
		if(len != t.length()) {
			return false;
		}
		
		//iterate through each character 
		for(int i = 0;i<len;i++) {
			//check the index of current character in string s
			// is different from the corresonding charcter 
			if(indexS[s.charAt(i)] != indexT[t.charAt(i)]) {
				return false;
			}
			
			
			//Update the indices of the string
			indexS[s.charAt(i)] = i+1;
			indexT[t.charAt(i)] = i+1;
			
		}
		
		
		return true;
		
		
		
	
        
    }
}