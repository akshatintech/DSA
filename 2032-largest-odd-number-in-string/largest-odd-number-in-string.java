class Solution {
    public String largestOddNumber(String num) {
        
        
		
		int ans;
		String str = "";
		String numb = "";
		for(int i = num.length()-1;i>=0;i--) {
			if(Integer.parseInt("" +num.charAt(i)) %2 != 0) {
				return num.substring(0 , i+1);
			}
		}
		
		return str;
	
    }
}